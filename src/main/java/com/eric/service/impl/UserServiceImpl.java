package com.eric.service.impl;

import com.eric.mapper.IUserMapper;
import com.eric.pojo.User;
import com.eric.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public User validateUser(String id, String password) {
        return userMapper.validateUser(id, password);
    }

    @Override
    public void Regist(User user) {

        userMapper.registerByUsernameAndPassword(user.getId(),user.getPassword(),user.getName());

    }
}

