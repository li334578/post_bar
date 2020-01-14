package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.User;
import lombok.Data;

@Data
public class UserDto extends User {
    private Integer article_total_num; //该用户的文章数
}
