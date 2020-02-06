package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.Article;
import lombok.Data;
/**
 * Author:   Tang
 * Date:     2020/1/27 15:30
 * Description: 文章dto
 */
@Data
public class ArticleDto extends Article {
    private Integer comment;
    private String type_name;
    private String author_name;
    private String user_avatar;
}
