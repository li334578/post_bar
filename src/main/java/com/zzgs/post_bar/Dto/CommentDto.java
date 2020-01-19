package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.Comment;
import lombok.Data;

import java.util.List;

@Data
public class CommentDto extends Comment {

    private String user_name;
    private String user_avatar;
    private List<CommentDto> son_comment;
}
