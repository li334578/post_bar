package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Comment;
import com.zzgs.post_bar.Dto.CommentDto;
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
    List<CommentDto> findAllCommentByArticleId(Integer article_id);

    /**
     * 根据文章id查询所有的一级评论 没有父级评论
     * @param article_id
     * @return
     */
    @Select("select * from comment where article_id = #{article_id} and parent_comment_id = 0")
    List<CommentDto> findAllCommentByArticleIdAndParentCommentId(Integer article_id);

    /**
     * 根据文章id查询该文章的评论数
     * @param article_id
     * @return
     */
    @Select("select count(id) from comment where article_id = #{article_id}")
    Integer findCommentTotalByArticleId(Integer article_id);

    /**
     * 根据评论id查询评论
     * @param comment_id
     * @return
     */
    @Select("select * from comment where id = #{comment_id}")
    Comment findById(Integer comment_id);

    /**
     * 根据评论id查询评论的Dto
     * @param comment_id
     * @return
     */
    @Select("select * from comment where id = #{comment_id}")
    CommentDto findCommentDtoById(Integer comment_id);

    /**
     * 根据用户id和评论时间查询评论
     * @param user_id
     * @param create_time
     * @return
     */
    @Select("select * from comment where user_id = #{user_id} and create_time = #{create_time}")
    Comment findByUserIdAndCommentTime(@Param("user_id")Integer user_id,
                                       @Param("create_time")String create_time);

    /**
     * 根据id修改son_comment_id字段的值
     * @param id
     * @param son_comment_id
     * @return
     */
    @Update("update comment set son_comment_id = #{son_comment_id} where id = #{id}")
    Integer updateSon_comment_idById(@Param("id")Integer id,
                                     @Param("son_comment_id")String son_comment_id);

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
            "#{create_time},#{content},#{approval_num},#{trample_num},#{parent_comment_id},#{son_comment_id})")
    Integer insertArticleComment(@Param("user_id")Integer user_id,@Param("article_id")Integer article_id,
                                 @Param("create_time")String create_time,@Param("content")String content,
                                 @Param("approval_num")Integer approval_num,@Param("trample_num")Integer trample_num,
                                 @Param("parent_comment_id")Integer parent_comment_id,
                                 @Param("son_comment_id")String son_comment_id);

    /**
     * 根据评论id删除评论态度
     * @param comment_id
     * @return
     */
    @Delete("delete comment_attitude where comment_id = #{comment_id}")
    Integer deleteCommentAttitudeByCommentId(Integer comment_id);
}
