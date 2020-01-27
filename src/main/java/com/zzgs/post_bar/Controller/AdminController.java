package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Dto.AuthorDto;
import com.zzgs.post_bar.Dto.TagDto;
import com.zzgs.post_bar.Dto.TypeDto;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TagService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2020/1/26 15:19
 * Description:
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

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "/admin/adminLogin";
    }


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
}
