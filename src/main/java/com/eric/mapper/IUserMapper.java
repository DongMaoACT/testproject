package com.eric.mapper;

import com.eric.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    //邮箱+密码方式登录
    User LoginUser(@Param("user_email") String email, @Param("user_password") String password);
    //通过邮箱获得用户信息
    User GetUserByEmail(User user);
    //通过姓名获得用户信息
    User GetUserByName(User user);
    //插入基本信息
    void registerBaseInfo(User user);
    //插入详细信息
    void registerPlusInfo(User user);
    //更新基本信息
    void updateUserBaseInfo(User user);
    //更新详细信息
    void updateUserPlusInfo(User user);
}
