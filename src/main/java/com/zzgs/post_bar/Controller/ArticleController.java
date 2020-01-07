package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TagService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
import com.zzgs.post_bar.Utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/findAll")
    public String findAll(){
        return "";
    }

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

    @RequestMapping("/article_details/{id}")
    public String article(@PathVariable("id")Integer id,Model model){
        ArticleDto articleDto = articleService.findById(id);
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            String accountname = subject.getPrincipal().toString();
            User user = userService.findByAccountName(accountname);
            model.addAttribute("user",user);
        }
        articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
        articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        List<Tag> tagList = tagService.findByArticleId(id);
        model.addAttribute("articleDto",articleDto);
        model.addAttribute("tagList",tagList);
        return "article_details";
    }
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
}
