package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Comment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 根据文章id查询所有的评论
     * @param article_id
     * @return
     */
    @Select("select * from comment where article_id = #{article_id}")
    List<Comment> findByArticleId(Integer article_id);

    /**
     * 根据文章id删除评论
     * @param article_id
     * @return
     */
    @Delete("delete comment where article_id = #{article_id}")
    Integer deleteByArticleId(Integer article_id);

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
    @Insert("insert into comment VALUES(null,#{user_id},#{article_id}," +
            "#{create_time},#{content},#{approval_num},#{trample_num},#{parent_comment_id})")
    Integer insertArticleComment(@Param("user_id")Integer user_id,@Param("article_id")Integer article_id,
                                 @Param("create_time")String create_time,@Param("content")String content,
                                 @Param("approval_num")Integer approval_num,@Param("trample_num")Integer trample_num,
                                 @Param("parent_comment_id")Integer parent_comment_id);

    /**
     * 根据评论id删除评论态度
     * @param comment_id
     * @return
     */
    @Delete("delete comment_attitude where comment_id = #{comment_id}")
    Integer deleteCommentAttitudeByCommentId(Integer comment_id);
}
