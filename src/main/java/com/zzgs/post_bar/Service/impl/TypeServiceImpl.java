package com.zzgs.post_bar.Service.impl;

import com.github.pagehelper.PageHelper;
import com.zzgs.post_bar.Bean.Tag;
import com.zzgs.post_bar.Bean.Type;
import com.zzgs.post_bar.Dto.TypeDto;
import com.zzgs.post_bar.Mapper.ArticleMapper;
import com.zzgs.post_bar.Mapper.TypeMapper;
import com.zzgs.post_bar.Service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 分页查询所有话题并按照话题下的文章数量统计降序排列
     *
     * @return
     */
    @Override
    public List<TypeDto> findAllPaging(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TypeDto> typeDtoList = typeMapper.findAllType();
        for (TypeDto typeDto : typeDtoList) {
            typeDto.setTotal_num(typeMapper.findTotalArticleNumByTypeId(typeDto.getId()));
        }
        return typeDtoList;
    }

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
     * 查询所有话题并按照话题下的文章数量统计降序排列
     * @return
     */
    @Override
    public List<TypeDto> findAll() {
        return typeMapper.findAll();
    }

    /**
     * 查询所有分类
     *
     * @return
     */
    @Override
    public List<TypeDto> findAllType() {
        return typeMapper.findAllType();
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

    /**
     * 查询该分类下的文章数量
     *
     * @param type_id
     * @return
     */
    @Override
    public Integer findTotalArticleNumByTypeId(Integer type_id) {
        return typeMapper.findTotalArticleNumByTypeId(type_id);
    }
}
