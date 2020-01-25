package com.zzgs.post_bar.Utils;

import com.zzgs.post_bar.Bean.Comment;
import com.zzgs.post_bar.Service.CommentService;

/**
 * Author:   Tang
 * Date:     2020/1/25 14:38
 * Description:
 */

public class CommentUtil {

//    @Autowired
//    private CommentService commentService;


    public static void updateFatherComment(CommentService commentService, Comment comment) {
        Integer parent_comment_id = comment.getParent_comment_id();
        if (parent_comment_id == 0) {
            //没有父级评论
        } else {
            //存在父级评论  修改父级评论的son_comment_id
            Comment fatherComment = commentService.findById(parent_comment_id);
            String sonComment = structureSonCommentId(fatherComment.getSon_comment_id(), comment.getId());
            commentService.updateSon_comment_idById(parent_comment_id, sonComment);
            updateFatherComment(commentService, fatherComment);
        }
    }

    public static void delSonComment(CommentService commentService, Comment comment) {
        String son_comment_id = comment.getSon_comment_id();
        if (son_comment_id != null) {
            if (son_comment_id.length() > 1) {
                //该评论有多个子评论
                String[] split = son_comment_id.split(",");
                for (String id : split) {
                    Comment comment1 = commentService.findById(Integer.valueOf(id));
                    if (comment1 != null) {
                        delSonComment(commentService, comment1);
                    }
                }
            } else if (son_comment_id.length() == 1) {
                //该评论只有一条子评论
                Comment comment1 = commentService.findById(Integer.valueOf(son_comment_id));
                if (comment1 != null) {
                    delSonComment(commentService, comment1);
                }
            }
        } else {
            //该评论无子评论
            updateFatherComment(commentService, comment);
            commentService.deleteByCommentId(comment.getId());
        }
    }

    public static String structureSonCommentId(String fatherCommentSonCommentId, Integer commentId) {
        if (fatherCommentSonCommentId != null && !"".equals(fatherCommentSonCommentId)) {
            if (fatherCommentSonCommentId.length() > 1 && fatherCommentSonCommentId.split(",").length > 1) {
                if (fatherCommentSonCommentId.indexOf(String.valueOf(commentId)) == 0) {
                    //该评论存在字符串的第一位
                    return fatherCommentSonCommentId.replace(commentId + ",", "");
                } else {
                    return fatherCommentSonCommentId.replace("," + commentId, "");
                }
            }else {
                return "";
            }
        }else {
            return "";
        }
    }
}
