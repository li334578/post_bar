package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Tag;

import java.util.Date;
import java.util.List;

public interface TagService {

    /**
     * 新增一个标签
     * @param tag_name 标签名
     * @param create_time 创建时间
     * @return
     */
    Integer addTag(String tag_name, String create_time);

    /**
     * 查询所有标签
     * @return
     */
    List<Tag> findAll();

    /**
     * 根据标签名查询标签
     * @param tag_name 标签名
     * @return
     */
    Tag findByTagName(String tag_name);
}
