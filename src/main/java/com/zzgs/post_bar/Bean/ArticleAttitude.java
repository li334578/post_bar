package com.zzgs.post_bar.Bean;

import lombok.Data;

/**
 * Author:   Tang
 * Date:     2020/1/4 12:40:55
 * Description: 用户对帖子态度的实体类
 */
@Data
public class ArticleAttitude {
    /**
     * @id 主键
     * @user_id 用户id
     * @article_id 文章id
     * @attitude 态度 0为不赞同 1为赞同
     */
    private Integer id;
    private Integer user_id;
    private Integer article_id;
    private Integer attitude;
}
