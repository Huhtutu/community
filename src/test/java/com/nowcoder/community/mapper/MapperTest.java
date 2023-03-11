package com.nowcoder.community.mapper;

import com.nowcoder.community.CommunityApplication;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void info()
    {
        User user = userMapper.selectById(1);
        System.out.println(user);

    }

    @Test
    public void update()
    {
        int i = userMapper.updatePassword(1, "123456");
        if(i>0){
            System.out.println("更新成功");
        }
    }

    @Test
    public void getPosts(){
        List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPosts(0, 0, 10);
        discussPosts.forEach(System.out::print);
    }
}
