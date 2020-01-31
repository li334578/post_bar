package com.zzgs.post_bar;

import com.zzgs.post_bar.Service.MailService;
import com.zzgs.post_bar.Utils.CodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Author:   Tang
 * Date:     2020/1/30 14:46
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailTest {

    @Autowired
    private MailService mailService;

    private static final String TO = "m18638623273@163.com";
//    private static final String TO = "2424417354@qq.com";
    private static final String SUBJECT = "测试邮件";
    private static final String CONTENT = "test content";

    /**
     * 测试发送普通邮件
     */
    @Test
    public void sendSimpleMailMessage() {
        mailService.sendSimpleMailMessge(TO, SUBJECT, CONTENT);
    }

    @Test
    public void createCodeTest(){
        System.out.println(CodeUtil.CreateCode());
    }
}
