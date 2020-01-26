package com.zzgs.post_bar.Service.impl;

import com.github.pagehelper.PageHelper;
import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Bean.ArticleAttitude;
import com.zzgs.post_bar.Dto.ArticleDto;
import com.zzgs.post_bar.Mapper.ArticleMapper;
import com.zzgs.post_bar.Service.ArticleService;
import com.zzgs.post_bar.Service.CommentService;
import com.zzgs.post_bar.Service.TypeService;
import com.zzgs.post_bar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private CommentService commentService;

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
        for (ArticleDto articleDto : list) {
            articleDto.setComment(commentService.findCommentTotalByArticleId(articleDto.getId()));
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
        }
        return list;
    }

    /**
     * 分页查询所有包含关键字的文章
     *
     * @param pageNum  起始页码
     * @param pageSize 每页数据条数
     * @param keyword  关键字
     * @return
     */
    @Override
    public List<ArticleDto> findAllByKeyword(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleDto> list = articleMapper.findAllByKeyword(keyword);
        for (ArticleDto articleDto : list) {
            articleDto.setComment(commentService.findCommentTotalByArticleId(articleDto.getId()));
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
        }
        return list;
    }

    /**
     * 根据点赞数降序查询所有文章
     *
     * @return
     */
    @Override
    public List<ArticleDto> findAllOrderByApprovalNum() {
        List<ArticleDto> list = articleMapper.findAllOrderByApprovalNum();
        for (ArticleDto articleDto : list) {
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
            articleDto.setComment(commentService.findCommentTotalByArticleId(articleDto.getId()));
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
        }
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

    /**
     * 根据文章id来增加文章的浏览数
     *
     * @param article_id
     * @return
     */
    @Override
    public Integer updateArticleBrowseVolume(Integer article_id) {
        return articleMapper.updateArticleBrowseVolume(article_id);
    }

    /**
     * 根据文章id和用户id来查询用户是否对文章发表过态度
     *
     * @param article_id
     * @param user_id
     * @return
     */
    @Override
    public ArticleAttitude findArticleAttitudeByUserIdAndArticleId(Integer article_id, Integer user_id) {
        return articleMapper.findArticleAttitudeByUserIdAndArticleId(article_id,user_id);
    }

    /**
     * 新增用户对文章的态度
     *
     * @param article_id
     * @param user_id
     * @param attitude
     * @return
     */
    @Override
    public Integer addArticleAttitude(Integer article_id, Integer user_id, Integer attitude) {
        return articleMapper.addArticleAttitude(article_id,user_id,attitude);
    }

    /**
     * 更新文章点赞数量
     *
     * @param article_id
     * @return
     */
    @Override
    public Integer updateArticleAttitudeApproval_num(Integer article_id) {
        return articleMapper.updateArticleAttitudeApproval_num(article_id);
    }

    /**
     * 更新文章点踩数量
     *
     * @param article_id
     * @return
     */
    @Override
    public Integer updateArticleAttitudeTrample_num(Integer article_id) {
        return articleMapper.updateArticleAttitudeTrample_num(article_id);
    }

    /**
     * 根据用户id查询用户的所有已发布的文章
     *
     * @param user_id
     * @return
     */
    @Override
    public List<ArticleDto> findAllArticleByUserId(Integer user_id,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return articleMapper.findAllArticleByUserId(user_id);
    }

    /**
     * 根据用户id查询用户的所有文章 包括草稿
     *
     * @param user_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ArticleDto> findMyArticleByUserId(Integer user_id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return articleMapper.findMyArticleByUserId(user_id);
    }

    /**
     * 根据文章id更新文章标题、内容、封面图、是否发布、描述信息、更新时间等
     * @param id
     * @param title
     * @param content
     * @param first_picture
     * @param published
     * @param description
     * @param update_time
     * @return
     */
    @Override
    public Integer updateArticleByArticleId(Integer id, String title, String content,
                                            String first_picture, Integer published,
                                            String description, String update_time) {
        return articleMapper.updateArticleByArticleId(id,title,content,first_picture,published,description,update_time);
    }

    /**
     * 根据type_id 查询该分类下的文章总数
     *
     * @param type_id
     * @return
     */
    @Override
    public Integer findTotalByTypeId(Integer type_id) {
        return articleMapper.findTotalByTypeId(type_id);
    }

    /**
     * 根据type_id 查询该分类下的文章
     * @param type_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ArticleDto> findArticleByTypeId(Integer type_id,Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleDto> list = articleMapper.findArticleByTypeId(type_id);
        for (ArticleDto articleDto : list) {
            articleDto.setComment(commentService.findCommentTotalByArticleId(articleDto.getType_id()));
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
        }
        return list;
    }

    /**
     * 根据tag_id 查询该分类下的文章
     *
     * @param tag_id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ArticleDto> findArticleByTagId(Integer tag_id, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleDto> list = articleMapper.findArticleByTagId(tag_id);
        for (ArticleDto articleDto : list) {
            articleDto.setComment(commentService.findCommentTotalByArticleId(articleDto.getType_id()));
            articleDto.setType_name(typeService.findById(articleDto.getType_id()).getType_name());
            articleDto.setAuthor_name(userService.findById(articleDto.getUser_id()).getNick_name());
            articleDto.setUser_avatar(userService.findById(articleDto.getUser_id()).getUser_avatar());
        }
        return list;
    }

    /**
     * 根据tag_id查询当前标签下的文章数
     *
     * @param tag_id
     * @return
     */
    @Override
    public Integer findTotalByTagId(Integer tag_id) {
        return articleMapper.findTotalByTagId(tag_id);
    }

    /**
     * 根据文章id删除文章
     *
     * @param aritcle_id
     * @return
     */
    @Override
    public Integer deleteArticleByArticleId(Integer aritcle_id) {
        return articleMapper.deleteArticleByArticleId(aritcle_id);
    }

    /**
     * 根据文章id删除文章的标签
     *
     * @param article_id
     * @return
     */
    @Override
    public Integer deleteArticleTag(Integer article_id) {
        return articleMapper.deleteArticleTag(article_id);
    }

    /**
     * 根据文章id删除用户对文章的点赞和点踩
     *
     * @param article_id
     * @return
     */
    @Override
    public Integer deleteArticleAttitudeByArticleId(Integer article_id) {
        return articleMapper.deleteArticleAttitudeByArticleId(article_id);
    }

    /**
     * 根据文章id删除文章下的所有评论
     *
     * @param article_id
     * @return
     */
    @Override
    public Integer deleteArticleComment(Integer article_id) {
        return articleMapper.deleteArticleComment(article_id);
    }
}
