package com.nowcoder.community.util;

import com.nowcoder.community.CommunityApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {

    @Resource
    private MailClient mailClient;

    @Resource
    private TemplateEngine templateEngine;

    @Test
    public void textMail(){
        mailClient.send("424307574@qq.com","Test","Welcome!");
    }

    @Test
    public void textHtml(){
        Context context = new Context();
        context.setVariable("username","Hututu");
        String content = templateEngine.process("mail/test_mail", context);
        System.out.println(("邮件->" + context));

        mailClient.send("424307574@qq.com","HTMl",content);
    }
}

