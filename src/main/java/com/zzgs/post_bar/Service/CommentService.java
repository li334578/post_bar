package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.Comment;
import com.zzgs.post_bar.Dto.CommentDto;

import java.util.List;

public interface CommentService {

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
                                 Integer parent_comment_id);

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

}
