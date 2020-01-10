package com.zzgs.post_bar.Service.impl;

import com.zzgs.post_bar.Mapper.CommentMapper;
import com.zzgs.post_bar.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    /**
     * 新增一条评论
     *
     * @param user_id
     * @param article_id
     * @param create_time
     * @param content
     * @param approval_num
     * @param trample_num
     * @param parent_comment_id
     * @return
     */
    @Override
    public Integer insertArticleComment(Integer user_id, Integer article_id, String create_time, String content, Integer approval_num, Integer trample_num, Integer parent_comment_id) {
        return commentMapper.insertArticleComment(user_id,article_id,create_time,content,approval_num,trample_num,parent_comment_id);
    }
}
