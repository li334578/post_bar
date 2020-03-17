package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Article;
import com.zzgs.post_bar.Bean.ArticleAttitude;
import com.zzgs.post_bar.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    /**
     * 分页查询所有帖子
     * @param pageNum 起始页码
     * @param pageSize 每页数据条数
     * @return 文章列表
     */
    List<ArticleDto> findAll(Integer pageNum, Integer pageSize);

    /**
     * 分页查询所有包含关键字的文章
     * @param pageNum 起始页码
     * @param pageSize 每页数据条数
     * @param keyword 关键字
     * @return 文章列表
     */
    List<ArticleDto> findAllByKeyword(Integer pageNum, Integer pageSize,String keyword);
    /**
     * 根据点赞数降序查询所有文章
     * @return 文章列表
     */
    List<ArticleDto> findAllOrderByApprovalNum();

    /**
     * 根据点赞数降序分页查询所有文章
     * @param pageNum 起始页码
     * @param pageSize 每页数据条数
     * @return 分页文章列表
     */
    List<ArticleDto> findAllOrderByApprovalNumPaging(Integer pageNum, Integer pageSize);


    /**
     * 分页查询所有包含关键字的文章根据点赞数排序
     * @param pageNum 起始页码
     * @param pageSize 每页数据条数
     * @param keyword 关键字
     * @return 分页文章列表
     */
    List<ArticleDto> findAllByKeywordOrderByApprovalNum(Integer pageNum, Integer pageSize,String keyword);

    /**
     * 根据id查询article
     * @param id 文章id
     * @return 文章信息
     */
    ArticleDto findById(Integer id);
    /**
     * 新增一篇帖子
     * @param title 标题
     * @param content 内容
     * @param create_time 创建时间
     * @param update_time 更新时间
     * @param first_picture 封面地址
     * @param published 是否发布
     * @param description 文章描述
     * @param type_id 类型
     * @param user_id 用户
     * @param approval_num 点赞数
     * @param trample_num 点踩数
     * @param browse_volume 浏览数
     * @return 新增的行数
     */
    Integer addArticle(String title, String content, String create_time,
                       String update_time, String first_picture, Integer published,
                       String description, Integer type_id, Integer user_id,
                       Integer approval_num, Integer trample_num,Integer browse_volume);

    /**
     * 添加帖子的标签
     * @param article_id 帖子id
     * @param tag_id 标签id
     * @return 新增的文章行数
     */
    Integer addArticleTag(Integer article_id, Integer tag_id);


    /**
     * 根据用户id和创建时间来唯一的查询一篇帖子
     * @param user_id 用户id
     * @param create_time 创建时间
     * @return 文章信息
     */
    Article findByUserIdAndCreateTime(Integer user_id, String create_time);

    /**
     * 根据文章id来增加文章的浏览数
     * @param article_id 文章id
     * @return 更新文章浏览数的行数
     */
    Integer updateArticleBrowseVolume(Integer article_id);

    /**
     * 根据文章id和用户id来查询用户是否对文章发表过态度
     * @param article_id 文章id
     * @param user_id 用户id
     * @return 用户对文章发布态度的信息
     */
    ArticleAttitude findArticleAttitudeByUserIdAndArticleId(Integer article_id,
                                                            Integer user_id);

    /**
     * 新增用户对文章的态度
     * @param article_id 文章id
     * @param user_id 用户id
     * @param attitude 点赞/点踩
     * @return 新增的行数
     */
    Integer addArticleAttitude(Integer article_id,
                               Integer user_id,
                               Integer attitude);

    /**
     * 更新文章点赞数量
     * @param article_id 文章id
     * @return 更新的行数
     */
    Integer updateArticleAttitudeApproval_num(Integer article_id);

    /**
     * 更新文章点踩数量
     * @param article_id 文章id
     * @return 更新的行数
     */
    Integer updateArticleAttitudeTrample_num(Integer article_id);

    /**
     * 根据用户id查询用户的所有已发布的文章
     * @param user_id 文章id
     * @return 文章列表
     */
    List<ArticleDto> findAllArticleByUserId(Integer user_id,Integer pageNum, Integer pageSize);

    /**
     * 根据用户id查询用户的所有文章 包括草稿
     * @param user_id 用户id
     * @param pageNum 当前页码
     * @param pageSize 当前页的数据条数
     * @return 文章列表
     */
    List<ArticleDto> findMyArticleByUserId(Integer user_id,Integer pageNum, Integer pageSize);

    /**
     * 根据文章id更新文章标题、内容、封面图、是否发布、描述信息、更新时间等
     * @param id 文章id
     * @param title 文章标题
     * @param content 文章内容
     * @param first_picture 封面图地址
     * @param published 是否发布
     * @param description 文章描述
     * @param update_time 更新时间
     * @return 更新的行数
     */
    Integer updateArticleByArticleId(Integer id,String title,
                                     String content,String first_picture,
                                     Integer published,String description,String update_time);

    /**
     * 根据type_id 查询该分类下的文章总数
     *
     * @param type_id 分类id
     * @return 分类下的文章总数
     */
    Integer findTotalByTypeId(Integer type_id);

    /**
     * 根据type_id 查询该分类下的文章
     * @param type_id 分类id
     * @param pageNum 当前页页码
     * @param pageSize 当前页数据条数
     * @return 文章列表
     */
    List<ArticleDto> findArticleByTypeId(Integer type_id,Integer pageNum, Integer pageSize);


    /**
     * 根据type_id 查询该分类下的文章 根据点赞数排序
     * @param type_id 分类id
     * @param pageNum 当前页页码
     * @param pageSize 当前页数据条数
     * @return 文章列表
     */
    List<ArticleDto> findArticleByTypeIdOrderByApprovalNum(Integer type_id,Integer pageNum, Integer pageSize);

    /**
     * 根据tag_id 查询该分类下的文章
     *
     * @param tag_id 标签id
     * @param pageNum 当前页码
     * @param pageSize 当前页数据条数
     * @return 文章列表
     */
    List<ArticleDto> findArticleByTagId(Integer tag_id,Integer pageNum, Integer pageSize);

    /**
     * 根据tag_id 查询该分类下的文章
     *
     * @param tag_id 标签id
     * @param pageNum 当前页码
     * @param pageSize 当前页数据条数
     * @return 文章列表
     */
    List<ArticleDto> findArticleByTagIdOrderByApprovalNum(Integer tag_id,Integer pageNum, Integer pageSize);

    /**
     * 根据tag_id查询当前标签下的文章数
     *
     * @param tag_id 标签id
     * @return 当前标签下的文章数
     */
    Integer findTotalByTagId(Integer tag_id);

    /**
     * 根据文章id删除文章
     *
     * @param aritcle_id 文章id
     * @return 删除的文章行数
     */
    Integer deleteArticleByArticleId(Integer aritcle_id);

    /**
     * 根据文章id删除文章的标签
     *
     * @param article_id 文章id
     * @return 删除的标签行数
     */
    Integer deleteArticleTag(Integer article_id);

    /**
     * 根据文章id删除用户对文章的点赞和点踩
     *
     * @param article_id 文章id
     * @return 删除文章态度的行数
     */
    Integer deleteArticleAttitudeByArticleId(Integer article_id);

    /**
     * 根据文章id删除文章下的所有评论
     *
     * @param article_id 文章id
     * @return 删除评论的行数
     */
    Integer deleteArticleComment(Integer article_id);
}
