package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.ArticleAttitude;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.*;
import com.zzgs.post_bar.Service.*;
import com.zzgs.post_bar.Utils.MarkdownUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:   Tang
 * Date:     2020/1/26 15:19
 * Description: 管理员控制器
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;
    @Autowired
    CommentService commentService;

    /**
     * 跳转管理员登录页
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "/admin/adminLogin";
    }

    /**
     * 管理员登出
     * @return
     */
    @RequestMapping("/logout")
    public String logOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "/admin/adminLogin";
    }

    /**
     * 管理员登录请求
     * @param adminName 管理员账户
     * @param adminPassword 管理员密码
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(@Param("adminName")String adminName,
                        @Param("adminPassword")String adminPassword){
        Subject subject = SecurityUtils.getSubject();
        JSONObject jsonObject = new JSONObject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(adminName,adminPassword);
        try{
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException uae){
            //账户不存在 未知账户
            jsonObject.put("msg","账户不存在");
            jsonObject.put("statusCode","401");
        }catch (IncorrectCredentialsException ice){
            //密码错误
            jsonObject.put("msg","密码错误");
            jsonObject.put("statusCode","402");
        }
        if (subject.isAuthenticated()){
            if (subject.hasRole("admin")){
                //用户拥有权限
                jsonObject.put("msg","请求成功");
                jsonObject.put("statusCode","200");
            }else {
                //用户没有管理员权限
                jsonObject.put("msg","当前用户没有管理员权限");
                jsonObject.put("statusCode","403");
            }
        }
        return jsonObject.toString();
    }

    /**
     * 后台管理页
     * @param model 页面模型
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @return
     */
    @RequiresRoles({"admin"}) //当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/index")
    public String adminIndex(Model model,
                             @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                             @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询所有文章
        List<ArticleDto> articleDtoList = articleService.findAll(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("articleDtoList",articleDtoList);
        return "/admin/adminForums";
    }

    /**
     * 根据id查询文章详情
     * @param id 文章id
     * @param model 页面模型
     * @return
     */
    @RequiresRoles({"admin"}) //当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/adminArticleDetails/{id}")
    public String adminArticleDetails(@PathVariable("id")Integer id,Model model){
        ArticleDto articleDto = articleService.findById(id);
        //将文章的markdown内容转成html
        articleDto.setContent(MarkdownUtil.markdownToHtmlExtensions(articleDto.getContent()));
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            String accountname = subject.getPrincipal().toString();
            User user = userService.findByAccountName(accountname);
            //用户登录了 查询用户是否对文章发表过态度
            ArticleAttitude attitude = articleService.findArticleAttitudeByUserIdAndArticleId(id, user.getId());
            model.addAttribute("user",user);
            model.addAttribute("attitude",attitude);
        }
        articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
        articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
        List<Tag> tagList = tagService.findByArticleId(id);
        //查询文章的一级评论信息 没有父级评论的
        List<CommentDto> commentDtoList = commentService.findAllCommentByArticleIdAndParentCommentId(id);
        for (CommentDto commentDto : commentDtoList) {
            commentDto.setUser_name(userService.findById(commentDto.getUser_id()).getNick_name());
            commentDto.setUser_avatar(userService.findById(commentDto.getUser_id()).getUser_avatar());
            //设置子评论
            String son_comment_id = commentDto.getSon_comment_id();
            if (son_comment_id != null&&!"".equals(son_comment_id)) {
                //存在子评论信息
                List<CommentDto> son_comment_list = new ArrayList<>();
                String[] son_comment_id_arr = son_comment_id.split(",");
                for (String temp_son_comment_id : son_comment_id_arr) {
                    //根据子评论id查询评论信息
                    CommentDto son_commentDto = commentService.findCommentDtoById(Integer.valueOf(temp_son_comment_id));
                    son_commentDto.setUser_avatar(userService.findById(son_commentDto.getUser_id()).getUser_avatar());
                    son_commentDto.setUser_name(userService.findById(son_commentDto.getUser_id()).getNick_name());
                    son_comment_list.add(son_commentDto);
                }
                commentDto.setSon_comment(son_comment_list);
            }
        }
        model.addAttribute("articleDto",articleDto);
        model.addAttribute("tagList",tagList);
        model.addAttribute("commentDtoList",commentDtoList);
        return "/admin/adminArticleDetails";
    }

    /**
     * 文章分类页
     * @param model 页面模型
     * @param pageNum 当前页码
     * @param pageSize 当前页显示条数
     * @return
     */
    @RequiresRoles({"admin"}) //当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/types")
    public String adminType(Model model,
                            @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                            @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询所有的分类
        List<TypeDto> typeDtoList = typeService.findAllPaging(pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(typeDtoList);
        model.addAttribute("typeTotalNum",typeDtoList.size());
        model.addAttribute("typeDtoList",typeDtoList);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/adminTypes";
    }

    /**
     * 根据type_id查询分类下的文章
     * @param model 页面模型
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @param type_id 分类id
     * @return
     */
    @RequiresRoles({"admin"}) //当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/type/{id}")
    public String adminTypesIndex(Model model,
                            @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                            @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize,
                            @PathVariable("id")Integer type_id){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询当前type_id下的所有文章
        List<ArticleDto> articleDtoList = articleService.findArticleByTypeId(type_id,pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("articleDtoList",articleDtoList);
        //查询所有的分类
        List<TypeDto> typeDtoList = typeService.findAll();
        model.addAttribute("typeTotalNum",typeDtoList.size());
        model.addAttribute("typeDtoList",typeDtoList);
        model.addAttribute("currentTypeId",type_id);
        return "/admin/adminTypeForums";
    }

    @RequiresRoles({"admin"}) //当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/tags")
    public String adminTags(Model model,
                            @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                            @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询所有的标签
        List<TagDto> tagDtoList = tagService.findAllTagPaging(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(tagDtoList);
        model.addAttribute("tagTotalNum",tagDtoList.size());
        model.addAttribute("tagDtoList",tagDtoList);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/adminTags";
    }

    /**
     * 根据tag_id查询标签下的文章
     * @param model 页面模型
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @param tag_id 标签id
     * @return
     */
    @RequiresRoles({"admin"}) //当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/tag/{id}")
    public String adminTagsIndex(Model model,
                                  @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                                  @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize,
                                  @PathVariable("id")Integer tag_id){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //根据tag_id查询文章
        List<ArticleDto> articleDtoList = articleService.findArticleByTagId(tag_id,pageNum,pageSize);
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        //查询所有的分类
        List<TagDto> tagDtoList = tagService.findAll();
        for (TagDto tagDto : tagDtoList) {
            tagDto.setTotal_num(articleService.findTotalByTagId(tagDto.getId()));
        }
        model.addAttribute("tagTotalNum",tagDtoList.size());
        model.addAttribute("tagDtoList",tagDtoList);
        model.addAttribute("currentTagId",tag_id);
        //根据标签进行查询 在model中放入标志
        model.addAttribute("tag_id",tag_id);
        return "/admin/adminTagForums";
    }

    /**
     * 作者页
     * @param model 页面模型
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @return
     */
    @RequiresRoles({"admin"}) //当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/authors")
    public String adminAuthor(Model model,
                              @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                              @RequestParam(defaultValue = "6",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询所有的用户
        List<AuthorDto> authorDtoList = userService.findAllAuthorDto(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(authorDtoList);
        model.addAttribute("authorDtoList",authorDtoList);
        model.addAttribute("pageInfo",pageInfo);
        return "/admin/adminAuthor";
    }

    /**
     * 根据id删除分类
     * @param type_id 分类id
     * @return
     */
    @RequiresRoles({"admin"})//当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/delType")
    @ResponseBody
    public String delType(@RequestParam("type_id") Integer type_id){
        JSONObject jsonObject = new JSONObject();
        //查询该分类下的文章
        Integer num = typeService.findTotalArticleNumByTypeId(type_id);
        if (num>0){
            //说明该分类下有文章
            jsonObject.put("statusCode",500);
            jsonObject.put("msg","该分类下有"+num+"篇文章,不能删除该分类.");
        }else {
            //直接删除分类
            typeService.delTypeById(type_id);
            jsonObject.put("statusCode",200);
            jsonObject.put("msg","删除分类成功");
        }
        return jsonObject.toString();
    }

    /**
     * 根据标签id删除标签
     * @param tag_id 标签id
     * @return
     */
    @RequiresRoles({"admin"})//当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/delTag")
    @ResponseBody
    public String delTag(@RequestParam("tag_id") Integer tag_id) {
        JSONObject jsonObject = new JSONObject();
        //查询该标签下的文章
        Integer num = tagService.findTotalArticleNumByTagId(tag_id);
        if (num>0){
            //说明该标签下有文章
            jsonObject.put("statusCode",500);
            jsonObject.put("msg","该标签下有"+num+"篇文章,不能删除该标签.");
        }else {
            //直接删除
            tagService.delTagByTagId(tag_id);
            jsonObject.put("statusCode",200);
            jsonObject.put("msg","删除标签成功");
        }
        return jsonObject.toString();
    }

    /**
     * 根据文章id删除文章
     * @param article_id 文章id
     * @return
     */
    @RequiresRoles({"admin"})//当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/delArticle")
    @ResponseBody
    public String delArticle(@RequestParam("article_id") Integer article_id) {
        //删除文章并删除其他用户对文章的态度以及评论
        //1.删除文章
        articleService.deleteArticleByArticleId(article_id);
        //2.删除文章和文章标签的对应关系 article_tag
        articleService.deleteArticleTag(article_id);
        //3.删除文章其用户对文章的点赞/点踩态度
        articleService.deleteArticleAttitudeByArticleId(article_id);
        //4.删除文章及文章下的所有评论信息
        articleService.deleteArticleComment(article_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg","删除文章成功");
        jsonObject.put("statusCode","200");

        return jsonObject.toString();
    }

    /**
     * 根据作者id查询作者信息
     * @param model 页面模型
     * @param author_id 用户id
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @return
     */
    @RequiresRoles({"admin"})//当前controller需要具有admin角色才能访问 若没有该角色会报AuthorizationException异常
    @RequestMapping("/author_details/{id}")
    public String authorDetails(Model model,
                                @PathVariable("id") Integer author_id,
                                @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                                @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //根据作者id 查询出作者的信息
        User author = userService.findById(author_id);
        //根据作者id查询作者的文章
        List<ArticleDto> articleDtoList = articleService.findAllArticleByUserId(author_id, pageNum, pageSize);
        for (ArticleDto articleDto : articleDtoList) {
            articleDto.setComment(commentService.findCommentTotalByArticleId(articleDto.getId()));
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        }
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("author",author);
        return "/admin/adminAuthorDetails";
    }
}
