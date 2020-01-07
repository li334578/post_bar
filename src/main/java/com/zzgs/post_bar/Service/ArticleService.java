package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    /**
     * 分页查询所有帖子
     * @param pageNum 起始页码
     * @param pageSize 每页数据条数
     * @return
     */
    List<ArticleDto> findAll(Integer pageNum, Integer pageSize);

    /**
     * 新增一篇帖子
     * @param title 标题
     * @param content 内容
     * @param create_time 创建时间
     * @param update_time 更新时间
     * @param first_picture 封面地址
     * @param published 是否发布
     * @param description 文章描述
     * @param type_id 类型
     * @param user_id 用户
     * @param approval_num 点赞数
     * @param trample_num 点踩数
     * @param browse_volume 浏览数
     * @return
     */
    Integer addArticle(String title, String content, String create_time,
                       String update_time, String first_picture, Integer published,
                       String description, Integer type_id, Integer user_id,
                       Integer approval_num, Integer trample_num,Integer browse_volume);

    /**
     * 添加帖子的标签
     * @param article_id 帖子id
     * @param tag_id 标签id
     * @return
     */
    Integer addArticleTag(Integer article_id, Integer tag_id);


    /**
     * 根据用户id和创建时间来唯一的查询一篇帖子
     * @param user_id 用户id
     * @param create_time 创建时间
     * @return
     */
    Article findByUserIdAndCreateTime(Integer user_id, String create_time);
}