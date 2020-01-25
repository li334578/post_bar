package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Bean.ArticleAttitude;
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
     * 根据点赞数降序查询所有文章
     * @return
     */
    List<ArticleDto> findAllOrderByApprovalNum();

    /**
     * 根据id查询article
     * @param id
     * @return
     */
    ArticleDto findById(Integer id);
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

    /**
     * 根据文章id来增加文章的浏览数
     * @param article_id
     * @return
     */
    Integer updateArticleBrowseVolume(Integer article_id);

    /**
     * 根据文章id和用户id来查询用户是否对文章发表过态度
     * @param article_id
     * @param user_id
     * @return
     */
    ArticleAttitude findArticleAttitudeByUserIdAndArticleId(Integer article_id,
                                                            Integer user_id);

    /**
     * 新增用户对文章的态度
     * @param article_id
     * @param user_id
     * @param attitude
     * @return
     */
    Integer addArticleAttitude(Integer article_id,
                               Integer user_id,
                               Integer attitude);

    /**
     * 更新文章点赞数量
     * @param article_id
     * @return
     */
    Integer updateArticleAttitudeApproval_num(Integer article_id);

    /**
     * 更新文章点踩数量
     * @param article_id
     * @return
     */
    Integer updateArticleAttitudeTrample_num(Integer article_id);

    /**
     * 根据用户id查询用户的所有已发布的文章
     * @param user_id
     * @return
     */
    List<ArticleDto> findAllArticleByUserId(Integer user_id,Integer pageNum, Integer pageSize);

    /**
     * 根据用户id查询用户的所有文章 包括草稿
     * @param user_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ArticleDto> findMyArticleByUserId(Integer user_id,Integer pageNum, Integer pageSize);

    /**
     * 根据文章id更新文章标题、内容、封面图、是否发布、描述信息等
     * @param id
     * @param title
     * @param content
     * @param first_picture
     * @param published
     * @param description
     * @return
     */
    Integer updateArticleByArticleId(Integer id,String title,
                                     String content,String first_picture,
                                     Integer published,String description,String update_time);

    /**
     * 根据type_id 查询该分类下的文章总数
     * @param type_id
     * @return
     */
    Integer findTotalByTypeId(Integer type_id);

    /**
     * 根据type_id 查询该分类下的文章
     * @param type_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ArticleDto> findArticleByTypeId(Integer type_id,Integer pageNum, Integer pageSize);

    /**
     * 根据tag_id 查询该分类下的文章
     * @param tag_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ArticleDto> findArticleByTagId(Integer tag_id,Integer pageNum, Integer pageSize);

    /**
     * 根据tag_id查询当前标签下的文章数
     * @param tag_id
     * @return
     */
    Integer findTotalByTagId(Integer tag_id);

    /**
     * 根据文章id删除文章
     * @param aritcle_id
     * @return
     */
    Integer deleteArticleByArticleId(Integer aritcle_id);

    /**
     * 根据文章id删除文章的标签
     * @param article_id
     * @return
     */
    Integer deleteArticleTag(Integer article_id);

    /**
     * 根据文章id删除用户对文章的点赞和点踩
     * @param article_id
     * @return
     */
    Integer deleteArticleAttitudeByArticleId(Integer article_id);

    /**
     * 根据文章id删除文章下的所有评论
     * @param article_id
     * @return
     */
    Integer deleteArticleComment(Integer article_id);
}
