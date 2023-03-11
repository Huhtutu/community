package com.nowcoder.community.service.impl;

import com.nowcoder.community.entity.User;
import com.nowcoder.community.mapper.UserMapper;
import com.nowcoder.community.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public User findUserById(Integer id) {
        return userMapper.selectById(id);
    }
}
