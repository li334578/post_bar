package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TagService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
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
 * Date:     2019/12/30 14:48
 * Description:
 */
@Controller
public class LoginAndRegisterController {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    TypeService typeService;



    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                        @RequestParam(defaultValue = "2",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询帖子
        List<ArticleDto> articleDtoList = articleService.findAll(pageNum, pageSize);
        for (ArticleDto articleDto : articleDtoList) {
            articleDto.setComment(1);
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
        }
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(@Param("account_name") String account_name,
                        @Param("account_password") String account_password){
        Subject subject = SecurityUtils.getSubject();
        JSONObject jsonObject = new JSONObject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(account_name,account_password);
        try{
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException uae){
            //账户不存在 未知账户
            jsonObject.put("statusCode","401");
            jsonObject.put("msg","账户不存在");
        }catch (IncorrectCredentialsException ice){
            //密码错误
            jsonObject.put("statusCode","402");
            jsonObject.put("msg","密码错误");
        }
        if (subject.isAuthenticated()){
            jsonObject.put("statusCode","200");
            jsonObject.put("msg","请求成功");
            User user = userService.findByAccountName(account_name);
            jsonObject.put("nick_name",user.getNick_name());
            jsonObject.put("user_id",user.getId());
        }
        return jsonObject.toString();
    }

    @RequestMapping("/register")
    @ResponseBody
    public String register(@Param("register_nickname") String register_nickname,
                           @Param("register_account_name") String register_account_name,
                           @Param("register_account_password") String register_account_password){
        JSONObject jsonObject = new JSONObject();
        if (userService.findByNickName(register_nickname) != null) {
            //判断用户昵称是否存在
            //用户昵称已存在
            jsonObject.put("statusCode","401");
            jsonObject.put("msg","该昵称已存在");
        }else if (userService.findByAccountName(register_account_name) != null) {
            //判断账户名是否存在
            //账户名已存在
            jsonObject.put("statusCode","402");
            jsonObject.put("msg","该账户名已存在");
        }else {
            //对密码进行加密
            SimpleHash hash_account_password = new SimpleHash("MD5",register_account_password,register_account_name,10);
            userService.insertUser(register_nickname,register_account_name,hash_account_password.toString());
            jsonObject.put("statusCode","200");
            //注册成功为用户登录
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(register_account_name,register_account_password);
            subject.login(usernamePasswordToken);
            Integer user_id = userService.findByNickName(register_nickname).getId();
            jsonObject.put("nick_name",register_nickname);
            jsonObject.put("user_id",user_id);
        }
        return jsonObject.toString();
    }

    @RequestMapping("/logout")
    public String logout(Model model){
        model.addAttribute("nickname","");
        return "index";
    }
}
