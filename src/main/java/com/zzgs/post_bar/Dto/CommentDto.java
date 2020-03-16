package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.Comment;
import lombok.Data;

import java.util.List;
/**
 * Author:   Tang
 * Date:     2020/1/27 15:30
 * Description: 评论dto
 */
@Data
public class CommentDto extends Comment {
    /**
     * @user_name 用户名
     * @user_avatar 用户头像
     * @son_comment 子评论列表
     */
    private String user_name;
    private String user_avatar;
    private List<CommentDto> son_comment;
}
