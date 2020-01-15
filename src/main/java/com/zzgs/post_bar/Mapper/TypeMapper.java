package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Dto.TypeDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface TypeMapper {
    /**
     * 新增一个话题
     * @param type_name 话题名
     * @param create_time 创建时间
     * @return
     */
    @Insert("insert into type VALUES(null,#{type_name},#{create_time})")
    Integer addType(@Param("type_name") String type_name,
                   @Param("create_time") String create_time);

    /**
     * 查询所有话题并按照话题下的文章数量统计降序排列
     * @return
     */
    @Select("SELECT type.id,type.type_name,type.create_time,COUNT(type.id) AS total_num" +
            " FROM TYPE RIGHT JOIN article ON type.id = article.type_id" +
            " GROUP BY type.id ORDER BY COUNT(type.id) DESC")
    List<TypeDto> findAll();

    /**
     * 查询所有的分类
     * @return
     */
    @Select("select * from type")
    List<Type> findAllType();

    /**
     * 根据话题名查询话题
     * @param type_name 话题名
     * @return
     */
    @Select("select * from type where type_name = #{type_name}")
    Type findByTypeName(String type_name);

    /**
     * 根据id查询type
     * @param id
     * @return
     */
    @Select("select * from type where id = #{id}")
    Type findById(Integer id);
}
