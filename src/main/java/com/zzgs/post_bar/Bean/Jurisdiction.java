package com.zzgs.post_bar.Bean;

import lombok.Data;

/**
 * Author:   Tang
 * Date:     2019/12/31 13:39
 * Description: 权限实体类
 */
@Data
public class Jurisdiction {

    /**
     * @id 主键
     * @resource 允许访问的资源
     * @value 资源对应的权限
     * @sortnum 资源的权重
     */
    private Integer id;
    private String resource;
    private String value;
    private Integer sortnum;
}
