package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Service.CommentService;
import com.zzgs.post_bar.Service.UserService;
import com.zzgs.post_bar.Utils.DateUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/addComment")
    @ResponseBody
    public String addComment(@Param("article_id")Integer article_id,
                             @Param("content")String content,
                             @Param("parent_comment_id")Integer parent_comment_id){
        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        JSONObject jsonObject = new JSONObject();
        if (subject.getPrincipal() == null) {
            //用户没有登录
            jsonObject.put("statusCode",407);
            jsonObject.put("msg","需登录后才能评论");
        }else {
            String accountname = subject.getPrincipal().toString();
            User user = userService.findByAccountName(accountname);
            DateUtil dateUtil = new DateUtil();
            String create_time = dateUtil.getNowDate();
            Integer integer = commentService.insertArticleComment(user.getId(), article_id, create_time,
                    content, 0, 0, parent_comment_id);
            if (integer==0){
                //插入不成功
                jsonObject.put("statusCode",500);
                jsonObject.put("msg","评论失败，服务器出错");
            }else {
                //插入成功
                jsonObject.put("statusCode",200);
                jsonObject.put("msg","评论成功");
            }
        }
        return jsonObject.toString();
    }
}
