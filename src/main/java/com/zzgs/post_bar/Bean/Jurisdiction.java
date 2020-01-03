package com.zzgs.post_bar.Bean;

import lombok.Data;

/**
 * Author:   Tang
 * Date:     2019/12/31 13:39
 * Description:
 */
@Data
public class Jurisdiction {

    private Integer id; //权限id
    private String resource; //资源
    private String value; //访问方式
    private Integer sortnum; //权重
}
