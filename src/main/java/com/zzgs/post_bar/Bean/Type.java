package com.zzgs.post_bar.Bean;

import lombok.Data;

import java.util.Date;

/**
 * Author:   Tang
 * Date:     2020/1/4 11:20:30
 * Description: 帖子的话题实体类
 */
@Data
public class Type {
    /**
     * @id 主键
     * @type_name 话题名
     * @create_time 创建时间
     */
    private Integer id;
    private String type_name;
    private String create_time;
}
