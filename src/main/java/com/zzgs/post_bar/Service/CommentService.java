package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Comment;
import com.zzgs.post_bar.Dto.CommentDto;

import java.util.List;

public interface CommentService {

    /**
     * 根据评论id查询评论
     *
     * @param comment_id 评论id
     * @return 评论信息
     */
    Comment findById(Integer comment_id);

    /**
     * 根据用户id和创建时间来查询评论
     *
     * @param user_id 用户id
     * @param create_time 创建时间
     * @return 评论信息
     */
    Comment findByUserIdAndCommentTime(Integer user_id, String create_time);

    /**
     * 根据id修改评论的son_comment_id字段
     *
     * @param id 评论id
     * @param son_comment_id 子评论id
     * @return 修改的行数
     */
    Integer updateSon_comment_idById(Integer id, String son_comment_id);

    /**
     * 新增一条评论
     *
     * @param user_id 用户id
     * @param article_id 文章id
     * @param create_time 创建时间
     * @param content 评论内容
     * @param parent_comment_id 父评论id
     * @return 新增的行数
     */
    Integer insertArticleComment(Integer user_id,Integer article_id,
                                 String create_time,String content,
                                 Integer parent_comment_id,String son_comment_id);

    /**
     * 根据文章id 查询该文章的评论数
     *
     * @param article_id 文章id
     * @return 文章的评论数
     */
    Integer findCommentTotalByArticleId(Integer article_id);

    /**
     * 根据文章id查询文章的评论
     *
     * @param article_id 文章id
     * @return 文章的评论列表
     */
    List<CommentDto> findAllCommentByArticleId(Integer article_id);

    /**
     * 根据文章id查询文章的一级评论 没有父级评论的
     *
     * @param article_id 文章id
     * @return 文章的评论列表
     */
    List<CommentDto> findAllCommentByArticleIdAndParentCommentId(Integer article_id);

    /**
     * 根据id查询评论的Dto
     *
     * @param comment_id 评论id
     * @return 评论信息
     */
    CommentDto findCommentDtoById(Integer comment_id);

    /**
     * 根据评论id删除评论
     *
     * @param comment_id 评论id
     * @return 删除的行数
     */
    Integer deleteByCommentId(Integer comment_id);
}
