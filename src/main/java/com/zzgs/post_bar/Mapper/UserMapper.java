package com.zzgs.post_bar.Mapper;

import com.zzgs.post_bar.Bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

/**
 * Author:   Tang
 * Date:     2019/12/29 12:33
 * Description:
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findById(Integer id);

    /**
     * 根据用户名查询用户
     * @param account_name
     * @return
     */
    @Select("select * from user where account_name = #{account_name}")
    User findByAccountName(String account_name);

    /**
     * 根据用户昵称查询用户
     * @param nick_name
     * @return
     */
    @Select("select * from user where nick_name = #{nick_name}")
    User findByNickName(String nick_name);

    /**
     * 添加用户
     * @param nick_name
     * @param account_name
     * @param account_password
     * @return
     */
    @Insert("insert into user (id,account_name,account_password,nick_name,user_avatar) VALUES (null,#{account_name},#{account_password},#{nick_name},#{user_avatar})")
    Integer insertUser(@Param("nick_name") String nick_name,
                       @Param("account_name") String account_name,
                       @Param("account_password") String account_password,
                       @Param("user_avatar")String user_avatar);

    /**
     * 根据用户id查询用户角色
     * @param id
     * @return
     */
    @Select("SELECT role_name FROM role WHERE role.id = (SELECT user_role.id FROM user_role,USER WHERE user.id = #{id} AND user.id = user_role.id)")
    Set<String> findRolesById(Integer id);

    /**
     * 根据用户id修改用户信息
     * @param id
     * @param avatar
     * @param nick_name
     * @param mailbox
     * @param phone
     * @param intro
     * @return
     */
    @Update("update user set user_avatar = #{avatar},nick_name = #{nick_name},user_mailbox = #{mailbox}," +
            "user_phone = #{phone}, user_intro = #{intro} where id = #{id}")
    Integer updateUser(@Param("id") Integer id,@Param("avatar")String avatar,
                       @Param("nick_name")String nick_name,@Param("mailbox")String mailbox,
                       @Param("phone")String phone,@Param("intro")String intro);

}
