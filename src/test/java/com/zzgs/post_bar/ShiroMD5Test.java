package com.zzgs.post_bar;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * Author:   Tang
 * Date:     2019/12/30 14:04
 * Description:
 */
public class ShiroMD5Test {
    public static void main(String[] args) {
        String password = "1234";//明码
        String algorithmName = "MD5";//加密算法
        Object source = password;//要加密的密码

        Object salt = "admin2";//盐值，一般都是用户名或者userid，要保证唯一
        int hashIterations = 10;//加密次数
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);

        SimpleHash simpleHash = new SimpleHash(algorithmName,source,credentialsSalt,hashIterations);
        System.out.println(simpleHash);//打印出经过盐值、加密次数、md5后的密码
    }
}
