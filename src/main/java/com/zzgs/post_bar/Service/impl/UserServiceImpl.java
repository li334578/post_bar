package com.zzgs.post_bar.Service.impl;

import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Mapper.UserMapper;
import com.zzgs.post_bar.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Author:   Tang
 * Date:     2019/12/29 16:07
 * Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询所有用户方法
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 根据账户名获取账户信息
     *
     * @param account_name
     * @return
     */
    @Override
    public User findByAccountName(String account_name) {
        return userMapper.findByAccountName(account_name);
    }

    /**
     * 根据用户昵称查询用户
     *
     * @param nick_name
     * @return
     */
    @Override
    public User findByNickName(String nick_name) {
        return userMapper.findByNickName(nick_name);
    }

    /**
     * 用户注册
     *
     * @param nick_name        昵称名
     * @param account_name     账户名
     * @param account_password 账户密码
     * @param user_avatar      用户头像
     * @return
     */
    @Override
    public Integer insertUser(String nick_name, String account_name, String account_password, String user_avatar) {
        return userMapper.insertUser(nick_name, account_name, account_password,user_avatar);
    }


    /**
     * 根据用户id查询用户的角色
     *
     * @param id
     * @return
     */
    @Override
    public Set<String> findRolesById(Integer id) {
        return userMapper.findRolesById(id);
    }

    /**
     * 根据id修改用户的信息
     *
     * @param id
     * @param avatar
     * @param nick_name
     * @param mailbox
     * @param phone
     * @param intro
     * @return
     */
    @Override
    public Integer updateUser(Integer id, String avatar, String nick_name, String mailbox, String phone, String intro) {
        return userMapper.updateUser(id,avatar,nick_name,mailbox,phone,intro);
    }
}
