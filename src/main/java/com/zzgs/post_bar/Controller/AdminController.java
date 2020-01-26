package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Service.UserService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
