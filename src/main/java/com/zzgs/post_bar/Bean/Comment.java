package com.zzgs.post_bar.Bean;

import lombok.Data;

import java.util.Date;

/**
 * Author:   Tang
 * Date:     2020/1/4 12:35:55
 * Description: 评论实体类
 */
@Data
public class Comment {
    /**
     * @Id 主键
     * @user_id 用户id
     * @article_id 帖子id
     * @create_time 创建时间
     * @content 文章内容
     * @parent_comment_id 父级评论id
     * @son_comment_id 子级评论id的list.toString()
     */
    private Integer id;
    private Integer user_id;
    private Integer article_id;
    private String create_time;
    private String content;
    private Integer parent_comment_id;
    private String son_comment_id;
}
