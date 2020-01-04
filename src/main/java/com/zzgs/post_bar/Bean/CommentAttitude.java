package com.zzgs.post_bar.Bean;

import lombok.Data;

/**
 * Author:   Tang
 * Date:     2020/1/4 12:40:55
 * Description: 用户对评论态度的实体类
 */
@Data
public class CommentAttitude {
    /**
     * @id 主键
     * @user_id 用户id
     * @comment_id 评论id
     * @attitude 态度 0为不赞同 1为赞同
     */
    private Integer id;
    private Integer user_id;
    private Integer comment_id;
    private Integer attitude;
}
