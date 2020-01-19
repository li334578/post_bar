package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Comment;
import com.zzgs.post_bar.Dto.CommentDto;

import java.util.List;

public interface CommentService {

    /**
     * 根据评论id查询评论
     * @param comment_id
     * @return
     */
    Comment findById(Integer comment_id);

    /**
     * 根据用户id和创建时间来查询评论
     * @param user_id
     * @param create_time
     * @return
     */
    Comment findByUserIdAndCommentTime(Integer user_id, String create_time);

    /**
     * 根据id修改评论的son_comment_id字段
     * @param id
     * @param son_comment_id
     * @return
     */
    Integer updateSon_comment_idById(Integer id, String son_comment_id);

    /**
     * 新增一条评论
     * @param user_id
     * @param article_id
     * @param create_time
     * @param content
     * @param approval_num
     * @param trample_num
     * @param parent_comment_id
     * @return
     */
    Integer insertArticleComment(Integer user_id,Integer article_id,
                                 String create_time,String content,
                                 Integer approval_num,Integer trample_num,
                                 Integer parent_comment_id,String son_comment_id);

    /**
     * 根据文章id 查询该文章的评论数
     * @param article_id
     * @return
     */
    Integer findCommentTotalByArticleId(Integer article_id);

    /**
     * 根据文章id查询文章的评论
     * @param article_id
     * @return
     */
    List<CommentDto> findAllCommentByArticleId(Integer article_id);

    /**
     * 根据文章id查询文章的一级评论 没有父级评论的
     * @param article_id
     * @return
     */
    List<CommentDto> findAllCommentByArticleIdAndParentCommentId(Integer article_id);

    /**
     * 根据id查询评论的Dto
     * @param comment_id
     * @return
     */
    CommentDto findCommentDtoById(Integer comment_id);
}
