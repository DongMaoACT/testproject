package com.eric.service;
import com.eric.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class IUserServiceTest {
    @Autowired
    private IUserService IUserService;
    @Test
    public void LoginUser() {
        String email = "1520526911@qq.com";
        String password = "admin";
        User user = IUserService.LoginUser(email,password);
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getPassword());
    }

    @Test
    public void createUser(){
        User user = new User();
        user.setPassword("123456");
        user.setEmail("999999@qq.com");
        user.setName("ces");
        int i = IUserService.Regist(user);
        System.out.println(i);
    }
    @Test
    public void updateUserinfo(){
        User user = new User();
        user.setPassword("123456");
        user.setEmail("123255634@qq.com");
        user.setName("ewhgfaA");
        user.setPhone("12323423534");
        user.setLocation("西安");
        int i = IUserService.updateUserAllInfo(user);
        System.out.println(i);
    }
}

