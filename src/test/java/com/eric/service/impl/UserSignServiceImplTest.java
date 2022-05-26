package com.eric.service.impl;

import com.eric.service.UserSignService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserSignServiceImplTest {
    @Autowired
    public UserSignService userSignService;
    @Test
    public void updateSign() {
        int i = userSignService.updateSign(1);
        System.out.println(i);
    }

    @Test
    public void getSignSum() {
        int signSum = userSignService.getSignSum(1);
        System.out.println(signSum);
    }
}