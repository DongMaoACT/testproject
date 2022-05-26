package com.eric.service.impl;

import com.eric.mapper.IUserMapper;
import com.eric.pojo.User;
import com.eric.service.IUserService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public User LoginUser(String email, String password) {
        return userMapper.LoginUser(email, password);
    }

    @Override
    public int Regist(User user) {
        User existUser =userMapper.GetUserByEmail(user);
        if (existUser != null) {
            return -1;
        }else {
            //获取当前时间戳
            Date date = new Date(System.currentTimeMillis());
            user.setRegistration_date(date);
            //分数初始化
            user.setGrade(0);
            //插入基本信息
            userMapper.registerBaseInfo(user);
            //找到刚刚插入用户基本信息的主键
            User currentUser = userMapper.GetUserByEmail(user);
            user.setId(currentUser.getId());
            //插入详细信息
            userMapper.registerPlusInfo(user);
        }
        return 0;
    }
    @Override
    public int updateUserAllInfo(User user){
        User existUser =userMapper.GetUserByEmail(user);
        if (existUser != null) {
            user.setId(existUser.getId());
            userMapper.updateUserBaseInfo(user);
            userMapper.updateUserPlusInfo(user);
        }else {
            return -1;
        }
        return 0;
    }


}

