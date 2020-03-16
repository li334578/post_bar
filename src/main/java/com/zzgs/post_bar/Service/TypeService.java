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
     * @return 新增的行数
     */
    Integer addTag(String type_name, String create_time);

    /**
     * 查询所有话题并按照话题下的文章数量统计降序排列
     * @return 标签列表
     */
    List<TypeDto> findAll();

    /**
     * 分页查询所有话题并按照话题下的文章数量统计降序排列
     *
     * @return 分类列表
     */
    List<TypeDto> findAllPaging(Integer pageNum, Integer pageSize);

    /**
     * 查询所有分类
     *
     * @return 分类列表
     */
    List<TypeDto> findAllType();

    /**
     * 根据话题名查询话题
     * @param type_name 话题名
     * @return 分类信息
     */
    Type findByTypeName(String type_name);

    /**
     * 根据id查询话题分类
     *
     * @param type_id 分类id
     * @return 分类信息
     */
    Type findById(Integer type_id);


    /**
     * 查询该分类下的文章数量
     *
     * @param type_id 分类id
     * @return 分类下的文章数量
     */
    Integer findTotalArticleNumByTypeId(Integer type_id);

    /**
     * 根据id删除分类
     *
     * @param type_id 分类id
     */
    void delTypeById(Integer type_id);
}
