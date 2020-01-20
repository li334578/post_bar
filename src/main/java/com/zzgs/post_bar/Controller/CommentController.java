package com.zzgs.post_bar.Controller;

import com.alibaba.fastjson.JSONObject;
import com.zzgs.post_bar.Bean.Comment;
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
    public String addComment(@Param("article_id") Integer article_id,
                             @Param("content") String content,
                             @Param("parent_comment_id") Integer parent_comment_id) {
        //获取当前登录的用户
        Subject subject = SecurityUtils.getSubject();
        JSONObject jsonObject = new JSONObject();
        if (subject.getPrincipal() == null) {
            //用户没有登录
            jsonObject.put("statusCode", 407);
            jsonObject.put("msg", "需登录后才能评论");
        } else {
            //用户登录  判断评论内容是否为空
            if (content != null && !content.equals("")) {
                String accountname = subject.getPrincipal().toString();
                User user = userService.findByAccountName(accountname);
                DateUtil dateUtil = new DateUtil();
                String create_time = dateUtil.getNowDate();
                Integer integer = commentService.insertArticleComment(user.getId(), article_id, create_time,
                        content, 0, 0, parent_comment_id, null);
                if (integer == 0) {
                    //插入不成功
                    jsonObject.put("statusCode", 500);
                    jsonObject.put("msg", "评论失败，服务器出错");
                } else {
                    //插入成功
                    //根据parent_comment_id 查询是否存在该评论
                    Comment parent_comment = commentService.findById(parent_comment_id);
                    if (parent_comment != null) {
                        //存在该评论的父级评论
                        //当前评论
                        Comment comment = commentService.findByUserIdAndCommentTime(user.getId(), create_time);
                        String son_comment_id = null;
                        //存在父级评论 将id添加到父级评论的 son_comment_id
                        //获取到父级评论的原有子评论
                        son_comment_id = parent_comment.getSon_comment_id();
                        if (son_comment_id != null) {
                            //说明评论有子评论
                            son_comment_id = son_comment_id + "," + comment.getId();
                        } else {
                            //为空 说明该评论没有子级评论
                            son_comment_id = String.valueOf(comment.getId());
                        }
                        //根据id修改父级评论的son_comment_id字段
                        commentService.updateSon_comment_idById(parent_comment.getId(), son_comment_id);
                        //判断父级评论是否有父级评论
                        Integer parent_parent_comment_id = parent_comment.getParent_comment_id();
                        if (parent_parent_comment_id != 0){
                            //父级评论有父级评论 改变父级评论的父级评论的子评论信息
                            Comment parent_parent_comment = commentService.findById(parent_parent_comment_id);
                            String parent_son_comment_id = parent_parent_comment.getSon_comment_id();
                            parent_son_comment_id = parent_son_comment_id + "," + comment.getId();
                            //更新父级评论的父级评论的son_comment_id信息
                            commentService.updateSon_comment_idById(parent_parent_comment_id,parent_son_comment_id);
                        }
                    }
                    jsonObject.put("statusCode", 200);
                    jsonObject.put("msg", "评论成功");
                }
            } else {
                jsonObject.put("statusCode", 503);
                jsonObject.put("msg", "评论内容不能为空");
            }
        }
        return jsonObject.toString();
    }
}
