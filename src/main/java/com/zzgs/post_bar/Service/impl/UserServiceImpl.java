package com.zzgs.post_bar.Service.impl;

import com.github.pagehelper.PageHelper;
import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Dto.AuthorDto;
import com.zzgs.post_bar.Dto.UserDto;
import com.zzgs.post_bar.Mapper.ArticleMapper;
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

    @Autowired
    ArticleMapper articleMapper;

    /**
     * 查询所有用户方法
     *
     * @return 用户列表
     */
    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    /**
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 根据账户名获取账户信息
     *
     * @param account_name 账户name
     * @return 用户信息
     */
    @Override
    public User findByAccountName(String account_name) {
        return userMapper.findByAccountName(account_name);
    }

    /**
     * 根据用户昵称查询用户
     *
     * @param nick_name 昵称
     * @return 用户信息
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
     * @return 新增的行数
     */
    @Override
    public Integer insertUser(String nick_name, String account_name, String account_password, String user_avatar,String register_email) {
        return userMapper.insertUser(nick_name, account_name, account_password,user_avatar,register_email);
    }


    /**
     * 根据用户id查询用户的角色
     *
     * @param id 用户id
     * @return 用户的角色列表
     */
    @Override
    public Set<String> findRolesById(Integer id) {
        return userMapper.findRolesById(id);
    }

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
    @Override
    public Integer updateUser(Integer id, String avatar, String nick_name, String mailbox, String phone, String intro) {
        return userMapper.updateUser(id,avatar,nick_name,mailbox,phone,intro);
    }

    /**
     * 根据账户名来修改用户密码
     *
     * @param account_name 账户名
     * @param account_password 用户密码
     * @return 受影响的行数
     */
    @Override
    public Integer changePassword(String account_name, String account_password) {
        return userMapper.changePassword(account_name,account_password);
    }

    /**
     * 查询所有的作者author (发表过文章的user)
     *
     * @return 作者列表
     */
    @Override
    public List<UserDto> findAllAuthor(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserDto> userDtoList = userMapper.findAllAuthor();
        for (UserDto userDto : userDtoList) {
            userDto.setArticle_total_num(articleMapper.findAuthorArticleTotalNum(userDto.getId()));
        }
        return userDtoList;
    }

    /**
     * 为用户添加用户角色
     *
     * @param user_id 用户id
     */
    @Override
    public void addUserRole(Integer user_id) {
        userMapper.addUserRole(user_id);
    }

    /**
     * 分页查询所有的用户
     * @param pageNum 当前页码
     * @param pageSize 当前页数据条数
     * @return 用户列表
     */
    @Override
    public List<AuthorDto> findAllAuthorDto(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AuthorDto> authorDtoList = userMapper.findAllAuthorDto();
        for (AuthorDto authorDto : authorDtoList) {
            authorDto.setTotal_approval_num(userMapper.findApprovalNumByUserId(authorDto.getId()));
            authorDto.setTotal_comment_num(userMapper.findCommentNumByUserId(authorDto.getId()));
            authorDto.setTotal_published_article_num(userMapper.findPublishedArticleNumByUserId(authorDto.getId()));
            authorDto.setTotal_trample_num(userMapper.findTrampleNumByUserId(authorDto.getId()));
        }
        return authorDtoList;
    }
}
