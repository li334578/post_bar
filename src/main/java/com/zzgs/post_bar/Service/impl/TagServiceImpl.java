package com.zzgs.post_bar.Service.impl;

import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Mapper.TagMapper;
import com.zzgs.post_bar.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Integer addTag(String tag_name, String create_time) {
        return tagMapper.addTag(tag_name,create_time);
    }

    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }

    @Override
    public Tag findByTagName(String tag_name) {
        return tagMapper.findByTagName(tag_name);
    }
}
