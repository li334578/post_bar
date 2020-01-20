package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Dto.UserDto;
import com.zzgs.post_bar.Service.ArticleService;
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
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    ArticleService articleService;

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

    @RequestMapping("/author")
    public String author(Model model,
                         @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                         @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        List<UserDto> userDtoList = userService.findAllAuthor(pageNum, pageSize);
        PageInfo pageInfo = new PageInfo(userDtoList);
        model.addAttribute("userDtoList",userDtoList);
        model.addAttribute("pageInfo",pageInfo);
        return "author";
    }

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
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        }
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("author",author);
        return "author_details";
    }




}
