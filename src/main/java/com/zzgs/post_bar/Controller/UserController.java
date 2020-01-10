package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Service.TagService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
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

    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(@Param("avatar")String avatar,@Param("nick_name")String nick_name,
                             @Param("mailbox")String mailbox,@Param("phone")String phone,
                             @Param("intro")String intro){
        //格式校验？
        JSONObject jsonObject = new JSONObject();
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        Integer integer = userService.updateUser(user.getId(), avatar, nick_name, mailbox, phone, intro);
        if (integer==1){
            //修改成功
            jsonObject.put("statusCode",200);
            jsonObject.put("msg","修改成功");
        }else {
            //修改失败
            jsonObject.put("statusCode",500);
            jsonObject.put("msg","修改失败");
        }
        return jsonObject.toString();
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uploadImages(@RequestParam("file") MultipartFile file)throws IOException{
        JSONObject jsonObject = new JSONObject();
        System.out.println("upload方法执行了.....");
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
        String url=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\avatar";
        String url_target= System.getProperty("user.dir")+"\\target\\classes\\static\\images\\avatar";

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
        jsonObject.put("path","../static/images/avatar/"+fileName);
        jsonObject.put("statusCode",200);
        return jsonObject.toString();
    }




}
