package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.Comment;
import com.zzgs.post_bar.Dto.CommentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * Author:   Tang
 * Date:     2020/01/06 12:56:20
 * Description: 评论mapper
 */
@Mapper
public interface CommentMapper {
    /**
     * 根据文章id查询所有的评论
     * @param article_id 文章id
     * @return 评论列表
     */
    @Select("select * from comment where article_id = #{article_id}")
    List<CommentDto> findAllCommentByArticleId(Integer article_id);

    /**
     * 根据文章id查询所有的一级评论 没有父级评论
     * @param article_id 文章id
     * @return 评论列表
     */
    @Select("select * from comment where article_id = #{article_id} and parent_comment_id = 0")
    List<CommentDto> findAllCommentByArticleIdAndParentCommentId(Integer article_id);

    /**
     * 根据文章id查询该文章的评论数
     * @param article_id 文章id
     * @return 文章的评论数
     */
    @Select("select count(id) from comment where article_id = #{article_id}")
    Integer findCommentTotalByArticleId(Integer article_id);

    /**
     * 根据评论id查询评论
     * @param comment_id 评论id
     * @return 评论信息
     */
    @Select("select * from comment where id = #{comment_id}")
    Comment findById(Integer comment_id);

    /**
     * 根据评论id查询评论的Dto
     * @param comment_id 评论id
     * @return 评论信息
     */
    @Select("select * from comment where id = #{comment_id}")
    CommentDto findCommentDtoById(Integer comment_id);

    /**
     * 根据用户id和评论时间查询评论
     * @param user_id 用户id
     * @param create_time 评论创建时间
     * @return 评论信息
     */
    @Select("select * from comment where user_id = #{user_id} and create_time = #{create_time}")
    Comment findByUserIdAndCommentTime(@Param("user_id")Integer user_id,
                                       @Param("create_time")String create_time);

    /**
     * 根据id修改son_comment_id字段的值
     * @param id 评论id
     * @param son_comment_id 子评论id
     * @return 更新的行数
     */
    @Update("update comment set son_comment_id = #{son_comment_id} where id = #{id}")
    Integer updateSon_comment_idById(@Param("id")Integer id,
                                     @Param("son_comment_id")String son_comment_id);

    /**
     * 根据评论id删除评论
     * @param comment_id 评论id
     * @return 删除的行数
     */
    @Delete("delete from comment where id = #{comment_id}")
    Integer deleteByCommentId(Integer comment_id);

    /**
     * 新增一条评论
     * @param user_id 用户id
     * @param article_id 文章id
     * @param create_time 评论创建时间
     * @param content 文章内容
     * @param parent_comment_id 父评论id
     * @return 新增的行数
     */
    @Insert("insert into comment VALUES(null,#{user_id},#{article_id}," +
            "#{create_time},#{content},#{parent_comment_id},#{son_comment_id})")
    Integer insertArticleComment(@Param("user_id")Integer user_id,@Param("article_id")Integer article_id,
                                 @Param("create_time")String create_time,@Param("content")String content,
                                 @Param("parent_comment_id")Integer parent_comment_id,
                                 @Param("son_comment_id")String son_comment_id);

}
