package com.nowcoder.community.util;

import com.nowcoder.community.CommunityApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveFilterTest {

    @Resource
    private SensitiveFilter sensitiveFilter;

    @Test
    public void test(){
        String text = "嫖娼,赌博,";
        text = sensitiveFilter.filter(text);
        System.out.println((text));
    }
}
