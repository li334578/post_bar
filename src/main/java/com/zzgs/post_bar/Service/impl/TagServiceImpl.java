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
    /**
     * 新增一个标签
     * @param tag_name 标签名
     * @param create_time 创建时间
     * @return
     */
    @Override
    public Integer addTag(String tag_name, String create_time) {
        return tagMapper.addTag(tag_name,create_time);
    }
    /**
     * 查询所有标签
     * @return
     */
    @Override
    public List<Tag> findAll() {
        return tagMapper.findAll();
    }
    /**
     * 根据标签名查询标签
     * @param tag_name 标签名
     * @return
     */
    @Override
    public Tag findByTagName(String tag_name) {
        return tagMapper.findByTagName(tag_name);
    }

    /**
     * 根据article_id查询这个文章的所有标签
     *
     * @param article_id
     * @return
     */
    @Override
    public List<Tag> findByArticleId(Integer article_id) {
        return tagMapper.findByArticleId(article_id);
    }
}
