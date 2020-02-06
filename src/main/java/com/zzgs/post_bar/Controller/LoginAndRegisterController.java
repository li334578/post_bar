package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Bean.User;
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
import org.apache.shiro.crypto.hash.SimpleHash;
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
 * Date:     2019/12/30 14:48
 * Description: 登录页和注册页的控制类
 */
@Controller
public class LoginAndRegisterController {

    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;


    /**
     * 跳转首页
     * @param model 页面模型
     * @param pageNum 当前页
     * @param pageSize 每页显示条数
     * @param keyword 查询关键字
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(required = false,defaultValue = "1",value = "pageNum")Integer pageNum,
                        @RequestParam(defaultValue = "5",value = "pageSize")Integer pageSize,
                        @RequestParam(defaultValue = "",value = "keyword")String keyword){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        //查询帖子
        List<ArticleDto> articleDtoList;
        if ("".equals(keyword)){
            articleDtoList = articleService.findAll(pageNum, pageSize);
        }else {
            keyword = "%"+keyword+"%";
            articleDtoList = articleService.findAllByKeyword(pageNum, pageSize,keyword);
        }
        //查询所有的分类的前五个
        List<TypeDto> typeDtoList = typeService.findAll();
        if (typeDtoList.size()>=5){
            typeDtoList = typeDtoList.subList(0,5);
        }
        model.addAttribute("typeDtoList",typeDtoList);
        //查询所有的标签的前五个
        List<TagDto> tagDtoList = tagService.findAll();
        if (tagDtoList.size()>=5){
            tagDtoList = tagDtoList.subList(0,5);
        }
        //查询点赞数最多的文章的前五个
        List<ArticleDto> orderArticleDtoList = articleService.findAllOrderByApprovalNum();
        if (orderArticleDtoList.size()>=5){
            orderArticleDtoList = orderArticleDtoList.subList(0,5);
        }
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("typeDtoList",typeDtoList);
        model.addAttribute("tagDtoList",tagDtoList);
        model.addAttribute("orderArticleDtoList",orderArticleDtoList);
        return "index";
    }

    /**
     * 转发到关于我们页面
     * @param model 页面模型
     * @return
     */
    @RequestMapping("/about")
    public String aboutUs(Model model){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        return "about";
    }

    /**
     * 登录请求
     * @param account_name 账户名
     * @param account_password 账户密码
     * @return
     */
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

    /**
     * 注册请求
     * @param register_nickname 昵称
     * @param register_account_name 账户名
     * @param register_account_password 账户密码
     * @param register_email 账户email
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String register(@Param("register_nickname") String register_nickname,
                           @Param("register_account_name") String register_account_name,
                           @Param("register_account_password") String register_account_password,
                           @Param("register_email") String register_email){
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
            String defaultAvatar = "../static/images/avatar/Lighthouse.jpg";
            userService.insertUser(register_nickname,register_account_name,hash_account_password.toString(),defaultAvatar,register_email);
            jsonObject.put("statusCode","200");
            //注册成功为用户登录
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(register_account_name,register_account_password);
            subject.login(usernamePasswordToken);
            Integer user_id = userService.findByNickName(register_nickname).getId();
            //为用户授予角色信息
            userService.addUserRole(user_id);
            jsonObject.put("nick_name",register_nickname);
            jsonObject.put("user_id",user_id);
        }
        return jsonObject.toString();
    }

    /**
     * 查询账户名是否存在 注册时防止用户名重复
     * @param account_name 账户名
     * @return
     */
    @RequestMapping("/findAccountName")
    @ResponseBody
    public String findAccountName(@Param("account_name")String account_name){
        JSONObject jsonObject = new JSONObject();
        //查询用户名是否存在
        User user = userService.findByAccountName(account_name);
        if (user == null) {
            //用户不存在
            jsonObject.put("statusCode",200);
        }else {
            //用户名存在
            jsonObject.put("statusCode",500);
            jsonObject.put("msg","账户名已存在");
        }
        return jsonObject.toString();
    }

    /**
     * 查询昵称是否存在 注册时防止昵称重复
     * @param nickname 昵称
     * @return
     */
    @RequestMapping("/findNickname")
    @ResponseBody
    public String findNickname(@Param("nickname")String nickname){
        JSONObject jsonObject = new JSONObject();
        //查询用户名是否存在
        User user = userService.findByNickName(nickname);
        if (user == null) {
            //用户不存在
            jsonObject.put("statusCode",200);
        }else {
            //用户名存在
            jsonObject.put("statusCode",500);
            jsonObject.put("msg","昵称已存在");
        }
        return jsonObject.toString();
    }

    /**
     * 用户登出
     * @param model
     * @return
     */
    @RequestMapping("/logout")
    public String logout(Model model){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        model.addAttribute("user",null);
        return "redirect:/index";
    }
}
