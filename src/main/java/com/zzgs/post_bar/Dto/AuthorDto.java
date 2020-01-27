package com.zzgs.post_bar.Dto;

import com.zzgs.post_bar.Bean.User;
import lombok.Data;

/**
 * Author:   Tang
 * Date:     2020/1/27 15:30
 * Description:
 */
@Data
public class AuthorDto extends User {
    /**
     *
     * @totalPublishedArticleNum 用户发布文章数
     * @totalCommentNum 用户发布评论数
     * @totalApprovalNum 用户为他人点赞数
     * @totalTrampleNum 用户为他人点踩数
     */
    private Integer total_published_article_num;
    private Integer total_comment_num;
    private Integer total_approval_num;
    private Integer total_trample_num;
}
