package com.zzgs.post_bar.Bean;

import lombok.Data;

/**
 * Author:   Tang
 * Date:     2019/12/29 12:32
 *
 * Description: 用户实体类
 */
@Data
public class User {
    /**
     * @id 用户id
     * @account_name 用户名
     * @account_password 用户密码
     * @nick_name 用户昵称
     * @user_intro 用户简介
     * @user_mailbox 用户邮箱
     * @user_phone 用户手机号
     * @user_avatar 用户头像
     */
    private Integer id;
    private String account_name;
    private String account_password;
    private String nick_name;
    private String user_intro;
    private String user_mailbox;
    private String user_phone;
    private String user_avatar;
}
