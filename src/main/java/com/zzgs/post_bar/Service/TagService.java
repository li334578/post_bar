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
     * @return 新增的行数
     */
    Integer addTag(String tag_name, String create_time);

    /**
     * 查询所有标签并按照标签下的文章数量降序排列
     * @return 标签列表
     */
    List<TagDto> findAll();

    /**
     * 查询所有标签
     *
     * @return 标签列表
     */
    List<TagDto> findAllTag();

    /**
     * 分页查询所有标签
     *
     * @param pageNum 当前页码
     * @param pageSize 当前页的数据条数
     * @return 标签列表
     */
    List<TagDto> findAllTagPaging(Integer pageNum, Integer pageSize);

    /**
     * 分页查询所有标签根据标签下文章数排序
     * @param pageNum 当前页码
     * @param pageSize 当前页的数据条数
     * @return 标签列表
     */
    List<TagDto> findAllTagOrderByArticleNumPaging(Integer pageNum, Integer pageSize);

    /**
     * 根据标签名查询标签
     * @param tag_name 标签名
     * @return 标签信息
     */
    Tag findByTagName(String tag_name);

    /**
     * 根据article_id查询这个文章的所有标签
     *
     * @param article_id 文章id
     * @return 标签列表
     */
    List<Tag> findByArticleId(Integer article_id);

    /**
     * 根据tag_id查询tag_id下的文章数量
     *
     * @param tag_id 标签id
     * @return 当前标签下的文章数
     */
    Integer findTotalArticleNumByTagId(Integer tag_id);

    /**
     * 根据tag_id删除tag
     *
     * @param tag_id 标签id
     */
    void delTagByTagId(Integer tag_id);
}
