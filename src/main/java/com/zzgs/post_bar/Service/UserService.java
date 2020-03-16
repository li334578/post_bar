package com.zzgs.post_bar.Service;

import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.AuthorDto;
import com.zzgs.post_bar.Dto.UserDto;
import org.apache.ibatis.annotations.Param;

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
     *
     * @return 用户列表
     */
    List<User> findAll();

    /**
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    User findById(Integer id);

    /**
     * 根据账户名获取账户信息
     *
     * @param account_name 账户name
     * @return 用户信息
     */
    User findByAccountName(String account_name);

    /**
     * 根据用户昵称查询用户
     *
     * @param nick_name 昵称
     * @return 用户信息
     */
    User findByNickName(String nick_name);

    /**
     * 用户注册
     *
     * @param nick_name        昵称名
     * @param account_name     账户名
     * @param account_password 账户密码
     * @param user_avatar      用户头像
     * @return 新增的行数
     */
    Integer insertUser(String nick_name,String account_name,String account_password,String user_avatar,String register_email);

    /**
     * 根据用户id查询用户的角色
     *
     * @param id 用户id
     * @return 用户的角色列表
     */
    Set<String> findRolesById(Integer id);

    /**
     * 根据id修改用户的信息
     *
     * @param id 用户id
     * @param avatar 用户头像
     * @param nick_name 用户昵称
     * @param mailbox 用户邮箱
     * @param phone 用户手机号
     * @param intro 用户简介
     * @return 更新的行数
     */
    Integer updateUser(Integer id,String avatar,
                       String nick_name,String mailbox,
                       String phone,String intro);

    /**
     * 根据账户名来修改用户密码
     *
     * @param account_name 账户名
     * @param account_password 用户密码
     * @return 受影响的行数
     */
    Integer changePassword(String account_name, String account_password);

    /**
     * 查询所有的作者author (发表过文章的user)
     *
     * @return 作者列表
     */
    List<UserDto> findAllAuthor(Integer pageNum, Integer pageSize);

    /**
     * 为用户添加用户角色
     *
     * @param user_id 用户id
     */
    void addUserRole(Integer user_id);

    /**
     * 分页查询所有的用户
     * @param pageNum 当前页码
     * @param pageSize 当前页数据条数
     * @return 用户列表
     */
    List<AuthorDto> findAllAuthorDto(Integer pageNum, Integer pageSize);
}
