package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.User;

import java.util.List;
import java.util.Set;

/**
 * Author:   Tang
 * Date:     2019/12/29 16:07
 * Description:
 */
public interface UserService {
    /**
     * 查询所有用户方法
     * @return
     */
    List<User> findAll();

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据账户名获取账户信息
     * @param account_name
     * @return
     */
    User findByAccountName(String account_name);

    /**
     * 根据用户昵称查询用户
     * @param nick_name
     * @return
     */
    User findByNickName(String nick_name);

    /**
     * 用户注册
     * @param nick_name 昵称名
     * @param account_name 账户名
     * @param account_password 账户密码
     * @param user_avatar 用户头像
     * @return
     */
    Integer insertUser(String nick_name,String account_name,String account_password,String user_avatar);

    /**
     * 根据用户id查询用户的角色
     * @param id
     * @return
     */
    Set<String> findRolesById(Integer id);

    /**
     * 根据id修改用户的信息
     * @param id
     * @param avatar
     * @param nick_name
     * @param mailbox
     * @param phone
     * @param intro
     * @return
     */
    Integer updateUser(Integer id,String avatar,
                       String nick_name,String mailbox,
                       String phone,String intro);
}
