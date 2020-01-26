package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Bean.ArticleAttitude;
import com.zzgs.post_bar.Dto.ArticleDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2020/01/06 12:56:20
 * Description:
 */
@Mapper
public interface ArticleMapper {

    /**
     * 查询所有文章
     * @return
     */
    @Select("select * from article where published = 1")
    List<ArticleDto> findAll();

    /**
     * 根据关键字查询所有的文字
     * @param keyword
     * @return
     */
    @Select("select * from article where published = 1 and content like #{keyword}")
    List<ArticleDto> findAllByKeyword(String keyword);
    /**
     * 根据点赞数降序查找所有文章
     * @return
     */
    @Select("select * from article where published = 1 order by approval_num DESC")
    List<ArticleDto> findAllOrderByApprovalNum();

    /**
     * 根据id查询article
     * @param id
     * @return
     */
    @Select("select * from article where id = #{id}")
    ArticleDto findById(Integer id);
    /**
     * 新增一篇帖子
     * @param title
     * @param content
     * @param create_time
     * @param update_time
     * @param first_picture
     * @param published
     * @param description
     * @param type_id
     * @param user_id
     * @param approval_num
     * @param trample_num
     * @param browse_volume
     * @return
     */
    @Insert("insert into article VALUE (null,#{title},#{content},#{create_time}," +
            "#{update_time},#{first_picture},#{published},#{description},#{type_id}," +
            "#{user_id},#{approval_num},#{trample_num},#{browse_volume})")
    Integer addArticle(@Param("title")String title,
                       @Param("content")String content,
                       @Param("create_time")String create_time,
                       @Param("update_time")String update_time,
                       @Param("first_picture")String first_picture,
                       @Param("published")Integer published,
                       @Param("description")String description,
                       @Param("type_id")Integer type_id,
                       @Param("user_id")Integer user_id,
                       @Param("approval_num")Integer approval_num,
                       @Param("trample_num")Integer trample_num,
                       @Param("browse_volume")Integer browse_volume);

    /**
     * 添加帖子的标签
     * @param article_id 帖子id
     * @param tag_id 标签id
     * @return
     */
    @Insert("insert into article_tag VALUE (null,#{article_id},#{tag_id})")
    Integer addArticleTag(@Param("article_id")Integer article_id,
                          @Param("tag_id")Integer tag_id);

    /**
     * 根据用户id和创建时间来唯一的查询一篇帖子
     * @param user_id 用户id
     * @param create_time 创建时间
     * @return
     */
    @Select("select * from article where user_id = #{user_id} and create_time = #{create_time}")
    Article findByUserIdAndCreateTime(@Param("user_id")Integer user_id,
                                      @Param("create_time")String create_time);

    /**
     * 根据博客id更新浏览量数据
     * @param article_id
     * @return
     */
    @Update("update article set browse_volume = browse_volume+1 where id = #{article_id}")
    Integer updateArticleBrowseVolume(@Param("article_id")Integer article_id);

    /**
     * 根据用户和文章id查询用户是否对文章发表过态度
     * @param article_id
     * @param user_id
     * @return
     */
    @Select("select * from article_attitude where article_id = #{article_id} and user_id = #{user_id}")
    ArticleAttitude findArticleAttitudeByUserIdAndArticleId(@Param("article_id")Integer article_id,
                                                            @Param("user_id")Integer user_id);

    /**
     * 新增用户对文章的态度
     * @param article_id
     * @param user_id
     * @param attitude
     * @return
     */
    @Insert("insert into article_attitude VALUES(null,#{user_id},#{article_id},#{attitude})")
    Integer addArticleAttitude(@Param("article_id")Integer article_id,
                               @Param("user_id")Integer user_id,
                               @Param("attitude")Integer attitude);

    /**
     * 根据文章id更新文章点赞数
     * @param article_id
     * @return
     */
    @Update("update article set approval_num = approval_num + 1 where id = #{article_id}")
    Integer updateArticleAttitudeApproval_num(@Param("article_id")Integer article_id);

    /**
     * 根据文章id更新文章点踩数
     * @param article_id
     * @return
     */
    @Update("update article set trample_num = trample_num + 1 where id = #{article_id}")
    Integer updateArticleAttitudeTrample_num(@Param("article_id")Integer article_id);

    /**
     * 根据用户id查询该用户的所有已发布的文章 create_time降序排列
      * @param user_id
     * @return
     */
    @Select("select * from article where user_id = #{user_id} and published = 1 ORDER BY create_time DESC")
    List<ArticleDto> findAllArticleByUserId(Integer user_id);

    /**
     * 查询用户的所有文章 包括未发布
     * @param user_id
     * @return
     */
    @Select("select * from article where user_id = #{user_id} ORDER BY create_time DESC")
    List<ArticleDto> findMyArticleByUserId(Integer user_id);

    @Update("update article set title = #{title},content = #{content},first_picture = #{first_picture}," +
            "published = #{published},description = #{description},update_time = #{update_time} where id = #{article_id}")
    Integer updateArticleByArticleId(@Param("article_id")Integer id,@Param("title")String title,
                                     @Param("content")String content,@Param("first_picture")String first_picture,
                                     @Param("published")Integer published,@Param("description")String description,
                                     @Param("update_time")String update_time);

    /**
     * 根据文章id删除文章
     * @param id
     * @return
     */
    @Delete("delete from article where id = #{id}")
    Integer deleteArticleByArticleId(Integer id);

    /**
     * 根据文章id删除用户对文章的点赞和点踩
     * @param article_id
     * @return
     */
    @Delete("delete from article_attitude where article_id = #{article_id}")
    Integer deleteArticleAttitudeByArticleId(Integer article_id);

    /**
     * 根据文章id删除文章的标签
     * @param article_id
     * @return
     */
    @Delete("delete from article_tag where article_id = #{article_id}")
    Integer deleteArticleTag(Integer article_id);

    /**
     * 根据文章id删除文章下的所有评论
     * @param article_id
     * @return
     */
    @Delete("delete from comment where article_id = #{article_id}")
    Integer deleteArticleComment(Integer article_id);

    /**
     * 根据type_id查询该分类下的文章数量
     * @param type_id
     * @return
     */
    @Select("select count(id) from article where type_id = #{type_id} and published = 1")
    Integer findTotalByTypeId(Integer type_id);

    /**
     * 根据type_id查询该分类下的所有文章
     * @param type_id
     * @return
     */
    @Select("select * from article where type_id = #{type_id} and published = 1")
    List<ArticleDto> findArticleByTypeId(Integer type_id);

    /**
     * 根据tag_id查询该标签下的所有文章
     * @param tag_id
     * @return
     */
    @Select("SELECT * FROM article WHERE article.id IN " +
            "(SELECT article_tag.article_id FROM article_tag WHERE article_tag.tag_id = #{tag_id}) and published = 1")
    List<ArticleDto> findArticleByTagId(Integer tag_id);

    /**
     * 根据tag_id查询该标签下的文章数量
     * SELECT COUNT(article_tag.id) from article_tag RIGHT JOIN article
     * ON article.id = article_tag.article_id and published = 1 and article_tag.tag_id = 2;
     * select count(id) from article_tag where tag_id = #{tag_id}
     * @param tag_id
     * @return
     */
    @Select("SELECT COUNT(article_tag.id) from article_tag RIGHT JOIN article" +
            " ON article.id = article_tag.article_id and published = 1 and article_tag.tag_id = #{tag_id}")
    Integer findTotalByTagId(Integer tag_id);

    /**
     * 根据用户id查询该用户发表的文章数
     * @param user_id
     * @return
     */
    @Select("SELECT COUNT(id) FROM article WHERE user_id = #{user_id} AND published = 1")
    Integer findAuthorArticleTotalNum(Integer user_id);
}
