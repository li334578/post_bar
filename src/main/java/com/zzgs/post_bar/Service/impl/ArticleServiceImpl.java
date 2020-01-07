package com.zzgs.post_bar.Service.impl;

import com.github.pagehelper.PageHelper;
import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Mapper.ArticleMapper;
import com.zzgs.post_bar.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 分页查询所有帖子
     * @param pageNum 起始页码
     * @param pageSize 每页数据条数
     * @return
     */
    @Override
    public List<ArticleDto> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleDto> list = articleMapper.findAll();
        return list;
    }

    /**
     * 根据id查询article
     * @param id
     * @return
     */
    @Override
    public ArticleDto findById(Integer id) {
        return articleMapper.findById(id);
    }

    /**
     * 新增一篇帖子
     *
     * @param title         标题
     * @param content       内容
     * @param create_time   创建时间
     * @param update_time   更新时间
     * @param first_picture 封面地址
     * @param published     是否发布
     * @param description   文章描述
     * @param type_id       类型
     * @param user_id       用户
     * @param approval_num  点赞数
     * @param trample_num   点踩数
     * @param browse_volume 浏览数
     * @return
     */
    @Override
    public Integer addArticle(String title, String content, String create_time,
                              String update_time, String first_picture, Integer published,
                              String description, Integer type_id, Integer user_id,
                              Integer approval_num, Integer trample_num,Integer browse_volume) {
        return articleMapper.addArticle(title,content,create_time,
                update_time,first_picture,published,description,type_id,user_id,
                approval_num,trample_num,browse_volume);
    }

    /**
     * 添加帖子的标签
     *
     * @param article_id 帖子id
     * @param tag_id     标签id
     * @return
     */
    @Override
    public Integer addArticleTag(Integer article_id, Integer tag_id) {
        return articleMapper.addArticleTag(article_id,tag_id);
    }

    /**
     * 根据用户id和创建时间来唯一的查询一篇帖子
     *
     * @param user_id     用户id
     * @param create_time 创建时间
     * @return
     */
    @Override
    public Article findByUserIdAndCreateTime(Integer user_id, String create_time) {
        return articleMapper.findByUserIdAndCreateTime(user_id,create_time);
    }
}
