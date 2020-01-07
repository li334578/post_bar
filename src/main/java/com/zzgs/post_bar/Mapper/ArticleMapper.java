package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Dto.ArticleDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Author:   Tang
 * Date:     2020/01/06 12:56:20
 * Description:
 */
@Mapper
public interface ArticleMapper {

    /**
     * 查询所有帖子
     * @return
     */
    @Select("select * from article")
    List<ArticleDto> findAll();

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
}
