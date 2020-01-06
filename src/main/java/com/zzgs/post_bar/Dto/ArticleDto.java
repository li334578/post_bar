package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.Article;
import lombok.Data;

@Data
public class ArticleDto extends Article {
    private Integer comment;
    private String type_name;
    private String author_name;
}
