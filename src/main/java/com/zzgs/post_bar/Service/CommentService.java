package com.zzgs.post_bar.Service;

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


}
