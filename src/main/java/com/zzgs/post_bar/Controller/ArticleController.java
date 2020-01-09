package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.*;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TagService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
import com.zzgs.post_bar.Utils.DateUtil;
import com.zzgs.post_bar.Utils.MarkdownUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2020/01/06 12:35
 * Description:
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService userService;

    @Autowired
    TagService tagService;

    @Autowired
    TypeService typeService;

    /**
     * 跳转到article_input页面
     * @param model 页面模型
     * @return
     */
    @RequestMapping("/article_input")
    public String article_input(Model model){
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        List<Type> typeList = typeService.findAll();
        List<Tag> tagList = tagService.findAll();
        model.addAttribute("user",user);
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);
        return "article_input";
    }

    /**
     * 查询文章详情
     * @param id 文章id
     * @param model 页面模型
     * @return
     */
    @RequestMapping("/article_details/{id}")
    public String article(@PathVariable("id")Integer id,Model model){
        ArticleDto articleDto = articleService.findById(id);
        //将文章的markdown内容转成html
        articleDto.setContent(MarkdownUtil.markdownToHtmlExtensions(articleDto.getContent()));
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            String accountname = subject.getPrincipal().toString();
            User user = userService.findByAccountName(accountname);
            model.addAttribute("user",user);
            //用户登录了 查询用户是否对文章发表过态度
            ArticleAttitude attitude = articleService.findArticleAttitudeByUserIdAndArticleId(id, user.getId());
            model.addAttribute("attitude",attitude);
        }
        articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
        articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        List<Tag> tagList = tagService.findByArticleId(id);
        model.addAttribute("articleDto",articleDto);
        model.addAttribute("tagList",tagList);
        return "article_details";
    }

    /**
     * 文章浏览数量
     * @param article_id 文章id
     * @return
     */
    @RequestMapping("/addArticleBrowseVolume")
    @ResponseBody
    public String addArticleBrowseVolume(@Param("article_id")Integer article_id){
        JSONObject jsonObject = new JSONObject();
        Integer flag = articleService.updateArticleBrowseVolume(article_id);
        if (flag == 1) {
            //更新成功
            jsonObject.put("statusCode",200);
        }else {
            jsonObject.put("statusCode",500);
        }
        return jsonObject.toJSONString();
    }

    /**
     * 查询当前用户对文章的态度
     * @param article_id
     * @return
     */
    @RequestMapping("/findArticleAttitude")
    @ResponseBody
    public String findArticleAttitude(@Param("article_id")Integer article_id){
        Subject subject = SecurityUtils.getSubject();
        JSONObject jsonObject = new JSONObject();
        if (subject.getPrincipal() == null) {
            //当前没有登录不能发表态度
            jsonObject.put("statusCode",402);
            jsonObject.put("msg","请登录后再发表态度");
        }else {
            //用户登录了 需判断用户之前是否对文章发表过态度
            String accountname = subject.getPrincipal().toString();
            User user = userService.findByAccountName(accountname);
            ArticleAttitude articleAttitude = articleService.
                    findArticleAttitudeByUserIdAndArticleId(article_id, user.getId());
            if (articleAttitude == null) {
                //该用户没对该文章发表过态度
                jsonObject.put("statusCode",200);
            }else {
                jsonObject.put("statusCode",502);
                jsonObject.put("msg","你已经为这篇文章发表过态度了");
            }
        }
        return jsonObject.toString();
    }

    /**
     * 添加用户对文章的态度
     * @param flag
     * @param article_id
     * @return
     */
    @RequestMapping("/addArticleAttitude")
    @ResponseBody
    public String addArticleAttitude(@Param("flag")Integer flag,
                                     @Param("article_id")Integer article_id){
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        JSONObject jsonObject = new JSONObject();
        Integer flag1 = articleService.addArticleAttitude(article_id, user.getId(), flag);
        if (flag1==1){
            //插入成功 更新文章的态度数量
            if (flag == 1){
                //点赞
                articleService.updateArticleAttitudeApproval_num(article_id);
            }else {
                //点踩
                articleService.updateArticleAttitudeTrample_num(article_id);
            }
            jsonObject.put("statusCode",200);
        }else {
            //服务器出现错误未插入成功
            jsonObject.put("statusCode",500);
        }
        return jsonObject.toString();
    }
    /**
     * 添加文章
     * @param title 文章标题
     * @param type_id 分类id
     * @param tag_arr 标签id的数组
     * @param firstPicture 封面图地址
     * @param description 文章描述信息
     * @param content 文章内容
     * @param published 是否发布 0为保存草稿 1为发布
     * @return
     */
    @RequestMapping("/addArticle")
    @ResponseBody
    public String addArticle(@Param("title")String title,
                             @Param("type_id")Integer type_id,
                             @Param("tag_arr")int[] tag_arr,
                             @Param("firstPicture") String firstPicture,
                             @Param("description") String description,
                             @Param("content") String content,
                             @Param("published") Integer published){
        //数据校验....

        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        //获取当前时间为创建时间和最后更新时间
        DateUtil dateUtil = new DateUtil();
        String dateTime = dateUtil.getNowDate();
        //创建JsonObject对象
        JSONObject jsonObject = new JSONObject();
        Integer addArticleNum = articleService.addArticle(title, content, dateTime, dateTime,
                firstPicture, published, description, type_id, user.getId(),
                0, 0,0);
        if (addArticleNum == 0) {
            jsonObject.put("statusCode",500);
        }else {
            Article article = articleService.findByUserIdAndCreateTime(user.getId(), dateTime);
            for (int i : tag_arr) {
                articleService.addArticleTag(article.getId(),i);
            }
            jsonObject.put("statusCode",200);
        }
        return jsonObject.toString();
    }

    /**
     * 编辑文章内容
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/articleEdit/{id}")
    public String articleEdit(@PathVariable("id")Integer id,Model model){
        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        ArticleDto articleDto = articleService.findById(id);
        articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        List<Type> typeList = typeService.findAll();
        List<Tag> tagList = tagService.findByArticleId(id);
        model.addAttribute("articleDto",articleDto);
        model.addAttribute("user",user);
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);
        return "article_edit";
    }

    /**
     * 分页查询我的文章
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/myArticle")
    public String myArticle(Model model,
                            @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                            @RequestParam(defaultValue = "2",value = "pageSize")Integer pageSize){
        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        String accountName = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountName);
        List<ArticleDto> articleDtoList = articleService.findAllArticleByUserId(user.getId(),pageNum,pageSize);
        for (ArticleDto articleDto : articleDtoList) {
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        }
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("user",user);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        return "my_article";
    }
}
