package com.nowcoder.community.mapper;

import com.nowcoder.community.CommunityApplication;
import com.nowcoder.community.entity.LoginTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class LoginTicketTest {

    @Resource
    private LoginTicketMapper loginTicketMapper;

    @Test
    public void show() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(123);
        loginTicket.setTicket("A");
        loginTicket.setStatus(1);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 6000 * 10 * 24));
        Integer integer = loginTicketMapper.insertLoginTicket(loginTicket);
        if (integer > 0) {
            System.out.println("添加成功！");
        }
    }

    @Test
    public void select(){
        LoginTicket loginTicket = loginTicketMapper.selecetByTicket("A");
        System.out.println("获取数据-->"+loginTicket);

        Integer integer = loginTicketMapper.updateStatus("A", 0);
        if (integer > 0) {
            System.out.println("修改成功！");
        }
    }
}
