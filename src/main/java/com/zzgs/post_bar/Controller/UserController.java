package com.zzgs.post_bar.Controller;

import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Service.TagService;
import com.zzgs.post_bar.Service.TypeService;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2019/12/29 12:33
 * Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TagService tagService;

    @Autowired
    TypeService typeService;


    @GetMapping("/findAll")
    public String findAll(){
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println("user = " + user);
        }
        return "index";
    }

    @RequestMapping("/userSetting")
    public String userSetting(Model model){
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        model.addAttribute("user",user);
        return "userSetting";
    }

    @RequestMapping("/forum_input")
    public String forum_input(Model model){
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        List<Type> typeList = typeService.findAll();
        List<Tag> tagList = tagService.findAll();
        model.addAttribute("user",user);
        model.addAttribute("typeList",typeList);
        model.addAttribute("tagList",tagList);
        return "forum_input";
    }


}
