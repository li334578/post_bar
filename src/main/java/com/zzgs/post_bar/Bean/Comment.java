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
     * @approval_num 点赞数
     * @trample_num 点踩数
     * @parent_comment_id 父级评论id
     */
    private Integer id;
    private Integer user_id;
    private Integer article_id;
    private Date create_time;
    private String content;
    private Integer approval_num;
    private Integer trample_num;
    private Integer parent_comment_id;
}
