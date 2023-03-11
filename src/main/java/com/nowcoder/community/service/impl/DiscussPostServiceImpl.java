package com.nowcoder.community.service.impl;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.mapper.DiscussPostMapper;
import com.nowcoder.community.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    @Resource
    private DiscussPostMapper discussPostMapper;
    @Override
    public List<DiscussPost> findDiscussPosts(Integer userId, Integer offset, Integer limit) {
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    @Override
    public Integer findDiscussPostRows(Integer userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
