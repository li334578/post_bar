package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Dto.UserDto;
import com.zzgs.post_bar.Service.*;
import com.zzgs.post_bar.Utils.CodeUtil;
import org.apache.commons.io.FileUtils;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Author:   Tang
 * Date:     2019/12/29 12:33
 * Description: 用户控制器
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

    @Autowired
    private MailService mailService;


    /**
     * 查询所有用户
     * @return 首页
     */
    @GetMapping("/findAll")
    public String findAll(){
        List<User> userList = userService.findAll();
        for (User user : userList) {
            System.out.println("user = " + user);
        }
        return "index";
    }

    /**
     * 用户资料设置页
     * @param model 页面模型
     * @return 用户设置页
     */
    @RequestMapping("/userSetting")
    public String userSetting(Model model){
        Subject subject = SecurityUtils.getSubject();
        String accountname = subject.getPrincipal().toString();
        User user = userService.findByAccountName(accountname);
        model.addAttribute("user",user);
        return "userSetting";
    }

    /**
     * 更新用户资料
     * @param avatar 头像
     * @param nick_name 昵称
     * @param mailbox 邮箱
     * @param phone 手机号
     * @param intro 描述
     * @return 更新用户资料的结果数据
     */
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

    /**
     * 上传头像文件
     * @param file 头像文件
     * @return 上传文件的结果数据
     * @throws IOException IO异常
     */
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

    /**
     * 作者页面
     * @param model 页面模型
     * @param pageNum 当前页
     * @param pageSize 每页显示数据
     * @return 作者页
     */
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

    /**
     * 跳转修改密码页
     * @param model 页面模型
     * @return 修改密码页
     */
    @RequestMapping("/changePwdPage")
    public String changePwdPage(Model model){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        return "change_password";
    }

    /**
     * 发送验证码邮件
     * @param account_name 账户名
     * @param request request对象
     * @return 发送邮件的结果数据
     */
    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendMail(@RequestParam("account_name")String account_name,
                           HttpServletRequest request){
        User userChangePwd = userService.findByAccountName(account_name);
        HttpSession session = request.getSession();
        JSONObject jsonObject = new JSONObject();
        String key = account_name+"Code";
        Integer code = CodeUtil.CreateCode();
        //将验证码存储到session中
        session.setAttribute(key,code);
        String title = "程序人生论坛-修改密码-验证码邮件";
        String content = "尊敬的用户，您好！您的验证码为["+code+"]，该验证码有效期为5分钟请您尽快使用。若不是本人操作请忽略本邮件";
        mailService.sendMimeMessge(userChangePwd.getUser_mailbox(),title,content);
        //五分钟后清除该验证码
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    CodeUtil.ClearCode(key,session);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },5*60*1000);
        jsonObject.put("statusCode",200);
        return jsonObject.toString();
    }

    /**
     * 修改用户密码
     * @param account_name 账户名
     * @param Code 验证码
     * @param NewPwd 新密码
     * @param ReNewPwd 再次确认密码
     * @param request request对象
     * @param model 页面模型
     * @return 修改密码的结果数据
     */
    @RequestMapping("/changePassword")
    @ResponseBody
    public String changePassword(@RequestParam("account_name")String account_name,
                                 @RequestParam("Code")String Code,
                                 @RequestParam("NewPwd")String NewPwd,
                                 @RequestParam("ReNewPwd")String ReNewPwd,
                                 HttpServletRequest request,Model model){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal()!=null){
            model.addAttribute("user",userService.findByAccountName(subject.getPrincipal().toString()));
        }
        JSONObject jsonObject = new JSONObject();
        //后端校验四个字段不为空
        if ("".equals(account_name)||account_name==null
                ||"".equals(Code)||Code==null
                ||"".equals(NewPwd)||NewPwd==null
                ||"".equals(ReNewPwd)||ReNewPwd==null){
            jsonObject.put("statusCode",505);
            jsonObject.put("msg","信息填写不完全，请检查");
        }else if (!NewPwd.equals(ReNewPwd)){
            jsonObject.put("statusCode",505);
            jsonObject.put("msg","两次密码不一致，请检查");
        }else {
            //校验通过
            HttpSession session = request.getSession();
            String key = account_name+"Code";
            Integer SessionCode = (Integer) session.getAttribute(key);
            if (String.valueOf(SessionCode).equals(Code)){
                //验证码一致
                //对密码进行加密
                SimpleHash hash_account_password = new SimpleHash("MD5",NewPwd,account_name,10);
                Integer integer = userService.changePassword(account_name, hash_account_password.toString());
                if (integer==1){
                    jsonObject.put("statusCode",200);
                    jsonObject.put("msg","修改密码成功");
                    //成功修改密码 清空session中的验证码
                    session.removeAttribute(key);
                }else {
                    jsonObject.put("statusCode",500);
                    jsonObject.put("msg","服务器出现异常");
                }
            }else if (SessionCode==null){
                jsonObject.put("statusCode",506);
                jsonObject.put("msg","验证码已过期，请重新获取");
            }else {
                jsonObject.put("statusCode",506);
                jsonObject.put("msg","验证码不正确，请检查");
            }
        }
        return jsonObject.toString();
    }

    /**
     * 查询作者详情
     * @param model 页面模型
     * @param author_id 作者id
     * @param pageNum 当前页
     * @param pageSize 每页数据条数
     * @return 作者详情页
     */
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
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
        }
        PageInfo pageInfo = new PageInfo(articleDtoList);
        model.addAttribute("articleDtoList",articleDtoList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("author",author);
        return "author_details";
    }
}
