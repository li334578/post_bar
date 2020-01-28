package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Dto.TypeDto;

import java.util.List;

public interface TypeService {

    /**
     * 新增一个话题
     * @param type_name 话题名
     * @param create_time 创建时间
     * @return
     */
    Integer addTag(String type_name, String create_time);

    /**
     * 查询所有话题并按照话题下的文章数量统计降序排列
     * @return
     */
    List<TypeDto> findAll();

    /**
     * 分页查询所有话题并按照话题下的文章数量统计降序排列
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<TypeDto> findAllPaging(Integer pageNum, Integer pageSize);

    /**
     * 查询所有分类
     * @return
     */
    List<TypeDto> findAllType();

    /**
     * 根据话题名查询话题
     * @param type_name 话题名
     * @return
     */
    Type findByTypeName(String type_name);

    /**
     * 根据id查询话题分类
     * @param id
     * @return
     */
    Type findById(Integer id);


    /**
     * 查询该分类下的文章数量
     * @param type_id
     * @return
     */
    Integer findTotalArticleNumByTypeId(Integer type_id);
}
