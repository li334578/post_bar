package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Dto.TagDto;

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
     * 查询所有标签并按照标签下的文章数量降序排列
     * @return
     */
    List<TagDto> findAll();

    /**
     * 查询所有标签
     * @return
     */
    List<TagDto> findAllTag();

    /**
     * 分页查询所有标签
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<TagDto> findAllTagPaging(Integer pageNum, Integer pageSize);

    /**
     * 根据标签名查询标签
     * @param tag_name 标签名
     * @return
     */
    Tag findByTagName(String tag_name);

    /**
     * 根据article_id查询这个文章的所有标签
     * @param article_id
     * @return
     */
    List<Tag> findByArticleId(Integer article_id);
}
