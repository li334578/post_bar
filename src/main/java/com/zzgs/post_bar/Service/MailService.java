package com.zzgs.post_bar.Service;

import org.springframework.stereotype.Service;

/**
 * Author:   Tang
 * Date:     2020/1/30 14:40
 * Description:
 */

public interface MailService {

    /**
     * 发送普通邮件
     *
     * @param to  收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendSimpleMailMessge(String to, String subject, String content);

    /**
     * 发送 HTML 邮件
     *
     * @param to  收件人
     * @param subject 主题
     * @param content 内容
     */
    void sendMimeMessge(String to, String subject, String content);

    /**
     * 发送带附件的邮件
     *
     * @param to  收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件路径
     */
    void sendMimeMessge(String to, String subject, String content, String filePath);
}
