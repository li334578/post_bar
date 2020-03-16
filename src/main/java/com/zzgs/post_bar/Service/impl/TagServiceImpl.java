package com.zzgs.post_bar.Service.impl;

import com.github.pagehelper.PageHelper;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Dto.TagDto;
import com.zzgs.post_bar.Mapper.TagMapper;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ArticleService articleService;
    /**
     * 新增一个标签
     * @param tag_name 标签名
     * @param create_time 创建时间
     * @return 新增的行数
     */
    @Override
    public Integer addTag(String tag_name, String create_time) {
        return tagMapper.addTag(tag_name,create_time);
    }
    /**
     * 查询所有标签并按照标签下的文章数量降序排列
     * @return 标签列表
     */
    @Override
    public List<TagDto> findAll() {
        return tagMapper.findAll();
    }

    /**
     * 分页查询所有标签
     *
     * @param pageNum 当前页码
     * @param pageSize 当前页的数据条数
     * @return 标签列表
     */
    @Override
    public List<TagDto> findAllTagPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TagDto> tagDtoList = tagMapper.findAllTag();
        for (TagDto tagDto : tagDtoList) {
            tagDto.setTotal_num(tagMapper.findTotalArticleNumByTagId(tagDto.getId()));
        }
        return tagDtoList;
    }

    /**
     * 查询所有标签
     *
     * @return 标签列表
     */
    @Override
    public List<TagDto> findAllTag() {
        return tagMapper.findAllTag();
    }

    /**
     * 根据标签名查询标签
     * @param tag_name 标签名
     * @return 标签信息
     */
    @Override
    public Tag findByTagName(String tag_name) {
        return tagMapper.findByTagName(tag_name);
    }

    /**
     * 根据article_id查询这个文章的所有标签
     *
     * @param article_id 文章id
     * @return 标签列表
     */
    @Override
    public List<Tag> findByArticleId(Integer article_id) {
        return tagMapper.findByArticleId(article_id);
    }

    /**
     * 根据tag_id查询tag_id下的文章数量
     *
     * @param tag_id 标签id
     * @return 当前标签下的文章数
     */
    @Override
    public Integer findTotalArticleNumByTagId(Integer tag_id) {
        return tagMapper.findTotalArticleNumByTagId(tag_id);
    }

    /**
     * 根据tag_id删除tag
     *
     * @param tag_id 标签id
     */
    @Override
    public void delTagByTagId(Integer tag_id) {
        tagMapper.delTagByTagId(tag_id);
    }
}
