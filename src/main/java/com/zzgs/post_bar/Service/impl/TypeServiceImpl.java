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

    @Override
    public Integer addTag(String type_name, String create_time) {
        return typeMapper.addType(type_name,create_time);
    }

    @Override
    public List<Type> findAll() {
        return typeMapper.findAll();
    }

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
