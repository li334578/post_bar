package com.zzgs.post_bar.Bean;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Author:   Tang
 * Date:     2020/1/4 11:18:55
 * Description: 帖子标签实体类
 */
@Data
public class Tag {
    /**
     * @id 主键
     * @tag_name 标签名
     * @create_time 创建时间
     */
    private Integer id;
    private String tag_name;
    private String create_time;
}
