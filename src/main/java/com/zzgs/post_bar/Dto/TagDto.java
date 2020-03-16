package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.Tag;
import lombok.Data;
/**
 * Author:   Tang
 * Date:     2020/1/27 15:30
 * Description: 标签dto
 */
@Data
public class TagDto extends Tag {
    /**
     * @total_num 标签下的文章数
     */
    private Integer total_num;
}
