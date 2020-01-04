package com.zzgs.post_bar.Bean;

import lombok.Data;

import java.util.Date;

/**
 * Author:   Tang
 * Date:     2020/1/4 11:24:55
 * Description: 帖子实体类
 */
@Data
public class Article {
    /**
     * @id 主键
     * @title 帖子标题
     * @content 帖子内容
     * @create_time 创建时间
     * @update_time 更新时间
     * @first_picture 封面图地址
     * @published 是否发布
     * @description 描述/摘要 信息
     * @type_id 文章所属话题
     * @user_id 文章所属用户 id
     * @approval_num 文章赞同数
     * @trample_num 文章点踩数
     */
    private Integer id;
    private String title;
    private String content;
    private Date create_time;
    private Date update_time;
    private String first_picture;
    private Integer published;
    private String description;
    private Integer type_id;
    private Integer user_id;
    private Integer approval_num;
    private Integer trample_num;
}
