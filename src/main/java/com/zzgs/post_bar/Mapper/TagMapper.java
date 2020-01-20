package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Dto.TagDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

/**
 * Author:   Tang
 * Date:     2020/1/4 13:21:55
 * Description:
 */
@Mapper
public interface TagMapper {

    /**
     * 新增一个标签
     * @param tag_name 标签名
     * @param create_time 创建时间
     * @return
     */
    @Insert("insert into tag VALUES(null,#{tag_name},#{create_time})")
    Integer addTag(@Param("tag_name") String tag_name,
                   @Param("create_time") String create_time);

    /**
     * 查询所有标签并按照标签下的文章数量降序排列
     * SELECT middle_table.id,middle_table.tag_name,middle_table.create_time,COUNT(middle_table.id) AS total_num from (SELECT tag.id,tag.tag_name,tag.create_time,article.published from (article_tag
     LEFT JOIN article ON article_tag.article_id = article.id)
     LEFT JOIN tag ON article_tag.tag_id = tag.id) middle_table
     where middle_table.published = 1 GROUP BY middle_table.id ORDER BY COUNT(middle_table.id) DESC;
     * @return
     */
    @Select("SELECT id,tag_name,create_time,COUNT(id) AS total_num from " +
            "(SELECT tag.id,tag.tag_name,tag.create_time,article.published from " +
            "(article_tag left join article ON article_tag.article_id = article.id) " +
            "left join tag ON article_tag.tag_id = tag.id) middle_table " +
            "where middle_table.published = 1 " +
            "GROUP BY middle_table.id " +
            "ORDER BY COUNT(middle_table.id) DESC")
    List<TagDto> findAll();

    /**
     * 查询所有标签
     * @return
     */
    @Select("select * from tag")
    List<Tag> findAllTag();
    /**
     * 根据标签名查询标签
     * @param tag_name 标签名
     * @return
     */
    @Select("select * from tag where tag_name = #{tag_name}")
    Tag findByTagName(String tag_name);

    /**
     * 根据article_id查询这个文章的所有标签
     * @param article_id
     * @return
     */
    @Select("SELECT * FROM tag WHERE tag.id IN " +
            "(SELECT article_tag.tag_id FROM article_tag WHERE article_tag.article_id = #{article_id})")
    List<Tag> findByArticleId(Integer article_id);
}
