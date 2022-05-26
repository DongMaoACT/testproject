package com.eric.service;

import com.eric.vo.ResponseVo;
import com.eric.vo.UserResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ResponseServiceTest {
    @Autowired
    public ResponseService responseService;
    @Test
    public void insertResponseDate() {
        UserResponse userResponse = new UserResponse();
        userResponse.setRuserId(1);
        userResponse.setDate(new Date());
        userResponse.setCommentId(1);
        userResponse.setReply("测试");
        ResponseVo responseVo = responseService.insertResponseDate(userResponse);
        System.out.println(responseVo);
    }

    @Test
    public void queryResponseDate() {
    }

    @Test
    public void deleteAll() {
    }
    @Test
    public void queryAllByCommentId(){
        List<ResponseVo> responseVos = responseService.queryAllByCommentId(1);
        for(ResponseVo r:responseVos){
            System.out.println(responseVos);
        }
    }
}