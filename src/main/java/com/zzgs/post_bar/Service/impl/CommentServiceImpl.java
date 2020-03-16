package com.zzgs.post_bar.Service.impl;

import com.zzgs.post_bar.Bean.Comment;
import com.zzgs.post_bar.Dto.CommentDto;
import com.zzgs.post_bar.Mapper.CommentMapper;
import com.zzgs.post_bar.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 根据评论id查询评论
     *
     * @param comment_id 评论id
     * @return 评论信息
     */
    @Override
    public Comment findById(Integer comment_id) {
        return commentMapper.findById(comment_id);
    }

    /**
     * 根据用户id和创建时间来查询评论
     *
     * @param user_id 用户id
     * @param create_time 创建时间
     * @return 评论信息
     */
    @Override
    public Comment findByUserIdAndCommentTime(Integer user_id, String create_time) {
        return commentMapper.findByUserIdAndCommentTime(user_id,create_time);
    }

    /**
     * 根据id修改评论的son_comment_id字段
     *
     * @param id 评论id
     * @param son_comment_id 子评论id
     * @return 修改的行数
     */
    @Override
    public Integer updateSon_comment_idById(Integer id, String son_comment_id) {
        return commentMapper.updateSon_comment_idById(id,son_comment_id);
    }

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
    @Override
    public Integer insertArticleComment(Integer user_id, Integer article_id,
                                        String create_time, String content,
                                        Integer parent_comment_id,String son_comment_id) {
        return commentMapper.insertArticleComment(user_id,article_id,create_time,content,parent_comment_id,son_comment_id);
    }

    /**
     * 根据文章id 查询该文章的评论数
     *
     * @param article_id 文章id
     * @return 文章的评论数
     */
    @Override
    public Integer findCommentTotalByArticleId(Integer article_id) {
        return commentMapper.findCommentTotalByArticleId(article_id);
    }

    /**
     * 根据文章id查询文章的评论
     *
     * @param article_id 文章id
     * @return 文章的评论列表
     */
    @Override
    public List<CommentDto> findAllCommentByArticleId(Integer article_id) {
        return commentMapper.findAllCommentByArticleId(article_id);
    }

    /**
     * 根据文章id查询文章的一级评论 没有父级评论的
     *
     * @param article_id 文章id
     * @return 文章的评论列表
     */
    @Override
    public List<CommentDto> findAllCommentByArticleIdAndParentCommentId(Integer article_id) {
        return commentMapper.findAllCommentByArticleIdAndParentCommentId(article_id);
    }

    /**
     * 根据id查询评论的Dto
     *
     * @param comment_id 评论id
     * @return 评论信息
     */
    @Override
    public CommentDto findCommentDtoById(Integer comment_id) {
        return commentMapper.findCommentDtoById(comment_id);
    }

    /**
     * 根据评论id删除评论
     *
     * @param comment_id 评论id
     * @return 删除的行数
     */
    @Override
    public Integer deleteByCommentId(Integer comment_id) {
        return commentMapper.deleteByCommentId(comment_id);
    }
}
