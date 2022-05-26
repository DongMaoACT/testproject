package com.eric.mapper;
import com.eric.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class IUserMapperTest {
    @Autowired
    private IUserMapper IUserMapper;
    @Test
    public void createUser(){
        User user = new User();
        user.setPassword("123456");
        user.setEmail("1232656314@qq.com");
        user.setName("ewhgfaA");
        IUserMapper.registerBaseInfo(user);
    }
}
