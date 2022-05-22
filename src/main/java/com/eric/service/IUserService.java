package com.eric.service;

import com.eric.pojo.User;


public interface IUserService {
    User validateUser(String id, String password);
    void Regist(User user);

}
