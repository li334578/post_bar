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

    private String user_name;
    private String user_avatar;
    private List<CommentDto> son_comment;
}
