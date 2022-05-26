package com.eric.service;

import com.eric.pojo.User;


public interface IUserService {

    /**
     * 用户登录
     * @param (id,password)
     * @return User
     */
    User LoginUser(String email, String password);

    /**
     * 用户注册
     * @param User
     * @return int
     */

    int Regist(User user);

    /**
     * 用户信息更新
     * @param User
     * @return int
     */

    int updateUserAllInfo(User user); //用户信息全部更新

}
