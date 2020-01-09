package com.zzgs.post_bar.Service.impl;

import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Mapper.TypeMapper;
import com.zzgs.post_bar.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;
    /**
     * 新增一个话题
     * @param type_name 话题名
     * @param create_time 创建时间
     * @return
     */
    @Override
    public Integer addTag(String type_name, String create_time) {
        return typeMapper.addType(type_name,create_time);
    }
    /**
     * 查询所有话题
     * @return
     */
    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }

    /**
     * 根据话题名查询话题
     * @param type_name 话题名
     * @return
     */
    @Override
    public Type findByTypeName(String type_name) {
        return typeMapper.findByTypeName(type_name);
    }

    /**
     * 根据id查询话题分类
     *
     * @param id
     * @return
     */
    @Override
    public Type findById(Integer id) {
        return typeMapper.findById(id);
    }
}
