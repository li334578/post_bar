package com.zzgs.post_bar.Realm;

import com.zzgs.post_bar.Bean.User;
import com.zzgs.post_bar.Service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:   Tang
 * Date:     2019/12/30 11:27
 * Description:
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.println("username = " + username);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = userService.findByAccountName(username);
        Set<String> roles = userService.findRolesById(user.getId());
        System.out.println(roles.toString());
        info.setRoles(roles);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String accountName = (String) authenticationToken.getPrincipal();
        String accountPassword = new String((char[]) authenticationToken.getCredentials());
//        String accountPassword = (String) authenticationToken.getCredentials();
        //根据用户名从数据库获取密码
        User user = userService.findByAccountName(accountName);
        //校验用户是否存在
        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        }
        //密码比较 Shiro内部进行比较
        ByteSource credentialsSalt = ByteSource.Util.bytes(accountName); //使用用户名作为用户的盐值
        //如果存在密码错误 会抛出IncorrectCredentialsException异常
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(accountName, user.getAccount_password(), credentialsSalt, getName());
        return info;
    }
}
