package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.User;
import lombok.Data;
/**
 * Author:   Tang
 * Date:     2020/1/27 15:30
 * Description:用户dto
 */
@Data
public class UserDto extends User {
    /**
     * @article_total_num 该用户的文章数
     */
    private Integer article_total_num;
}
