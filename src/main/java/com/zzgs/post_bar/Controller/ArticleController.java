package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.*;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Dto.CommentDto;
import com.zzgs.post_bar.Dto.TagDto;
import com.zzgs.post_bar.Dto.TypeDto;
import com.zzgs.post_bar.Service.*;
import com.zzgs.post_bar.Utils.DateUtil;
import com.zzgs.post_bar.Utils.MarkdownUtil;
import org.apache.commons.io.FileUtils;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

    @Autowired
    CommentService commentService;

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
        List<Type> typeList = typeService.findAllType();
        List<Tag> tagList = tagService.findAllTag();
        model.addAttribute("user",user);
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);
        return "article_input";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadImages(@RequestParam("file") MultipartFile file)throws IOException {
        JSONObject jsonObject = new JSONObject();
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        String url=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\cover";
        String url_target= System.getProperty("user.dir")+"\\target\\classes\\static\\images\\cover";

        try {
            file.transferTo(new File(url,fileName));
            File file_resources = new File(url+"\\"+fileName);
            File file_target = new File(url_target+"\\"+fileName);
            FileUtils.copyFile(file_resources,file_target);
        } catch (IOException e) {
            //文件保存出现异常
            jsonObject.put("msg","保存图片失败");
            e.printStackTrace();
        }
        jsonObject.put("path","../static/images/cover/"+fileName);
        jsonObject.put("statusCode",200);
        return jsonObject.toString();
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
        articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
        articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
        articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        List<Tag> tagList = tagService.findByArticleId(id);
        //查询文章的一级评论信息 没有父级评论的
        List<CommentDto> commentDtoList = commentService.findAllCommentByArticleIdAndParentCommentId(id);
        for (CommentDto commentDto : commentDtoList) {
            commentDto.setUser_name(userService.findById(commentDto.getUser_id()).getNick_name());
            commentDto.setUser_avatar(userService.findById(commentDto.getUser_id()).getUser_avatar());
            //设置子评论
            String son_comment_id = commentDto.getSon_comment_id();
            if (son_comment_id != null) {
                //存在子评论信息
                List<CommentDto> son_comment_list = new ArrayList<>();
                String[] son_comment_id_arr = son_comment_id.split(",");
                for (String temp_son_comment_id : son_comment_id_arr) {
                    //根据子评论id查询评论信息
                    CommentDto son_commentDto = commentService.findCommentDtoById(Integer.valueOf(temp_son_comment_id));
                    son_commentDto.setUser_name(userService.findById(son_commentDto.getUser_id()).getNick_name());
                    son_commentDto.setUser_avatar(userService.findById(son_commentDto.getUser_id()).getUser_avatar());
                    son_comment_list.add(son_commentDto);
                }
                commentDto.setSon_comment(son_comment_list);
            }
        }
        model.addAttribute("articleDto",articleDto);
        model.addAttribute("tagList",tagList);
        model.addAttribute("commentDtoList",commentDtoList);
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
        //更新文章的浏览量
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
            //查询用户对文章的态度
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
        System.out.println("title = " + title);
        System.out.println("type_id = " + type_id);
        System.out.println("tag_arr = " + tag_arr.toString());
        System.out.println("firstPicture = " + firstPicture);
        System.out.println("description = " + description);
        System.out.println("content = " + content);
        System.out.println("published = " + published);
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
        List<TypeDto> typeList = typeService.findAll();
        List<Tag> tagList = tagService.findByArticleId(id);
        model.addAttribute("articleDto",articleDto);
        model.addAttribute("user",user);
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);
        return "article_edit";
    }

    @RequestMapping("/updateArticle")
    @ResponseBody
    public String updateArticle(@Param("article_id")Integer article_id,@Param("title")String title,
                                @Param("content")String content,@Param("first_picture")String first_picture,
                                @Param("published")Integer published,@Param("description")String description){
        JSONObject jsonObject = new JSONObject();
        DateUtil dateUtil = new DateUtil();
        String update_time = dateUtil.getNowDate();
        Integer integer = articleService.updateArticleByArticleId(article_id, title, content,
                first_picture, published, description, update_time);
        if (integer==1){
            //更新成功
            jsonObject.put("statusCode",200);
        }else {
            //更新失败
            jsonObject.put("statusCode",500);
        }
        return jsonObject.toString();
    };

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
                            @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        String accountName = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountName);
        List<ArticleDto> articleDtoList = articleService.findMyArticleByUserId(user.getId(),pageNum,pageSize);
        for (ArticleDto articleDto : articleDtoList) {
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        }
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("user",user);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        return "my_article";
    }

    /**
     * 根据id删除文章
     * @param id
     * @return
     */
    @RequestMapping("/deleteMyArticle/{id}")
    @ResponseBody
    public String deleteMyArticle(@PathVariable("id")Integer id){
        //删除文章并删除其他用户对文章的态度以及评论
        //1.删除文章
        articleService.deleteArticleByArticleId(id);
        //2.删除文章和文章标签的对应关系 article_tag
        articleService.deleteArticleTag(id);
        //3.删除文章其用户对文章的点赞/点踩态度
        articleService.deleteArticleAttitudeByArticleId(id);
        //4.删除文章及文章下的所有评论信息
        articleService.deleteArticleComment(id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("statusCode","200");
        jsonObject.put("msg","删除文章成功");

        return jsonObject.toString();
    }
}
