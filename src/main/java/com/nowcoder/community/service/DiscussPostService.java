package com.nowcoder.community.service;

import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.mapper.DiscussPostMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface DiscussPostService {

    List<DiscussPost> findDiscussPosts(Integer userId, Integer offset, Integer limit);

    Integer findDiscussPostRows(Integer userId);
}
