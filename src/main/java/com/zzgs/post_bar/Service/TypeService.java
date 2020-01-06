package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;

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
     * 查询所有话题
     * @return
     */
    List<Type> findAll();

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
}
