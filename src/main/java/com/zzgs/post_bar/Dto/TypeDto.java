package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.Type;
import lombok.Data;
/**
 * Author:   Tang
 * Date:     2020/1/27 15:30
 * Description:分类dto
 */
@Data
public class TypeDto extends Type {
    /**
     * @total_num 分类下的文章数
     */
    private Integer total_num;
}
