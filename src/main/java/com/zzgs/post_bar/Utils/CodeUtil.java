package com.zzgs.post_bar.Utils;

import javax.servlet.http.HttpSession;

/**
 * Author:   Tang
 * Date:     2020/1/30 16:06
 * Description: 验证码的工具类
 */
public class CodeUtil {

    /**
     * 清除验证码
     * @param key 验证码的key
     * @param session session
     */
    public static void ClearCode(String key,HttpSession session ){
        session.removeAttribute(key);
    }

    /**
     * 创建验证码
     * @return 返回验证码
     */
    public static Integer CreateCode(){
        Integer code = new Double((Math.random()*9+1)*100000).intValue();
        return code;
    }
}
