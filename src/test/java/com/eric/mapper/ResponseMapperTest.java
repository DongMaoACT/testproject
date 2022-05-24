package com.eric.mapper;

import com.eric.pojo.ResponseData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ResponseMapperTest {
    @Autowired
    private ResponseMapper responseMapper;
    @Test
    public void insertResponse() {
        ResponseData responseData = new ResponseData();
        responseData.setResponseId(1);
        responseData.setCommentId(1);
        responseData.setRuserId("11122");
        responseData.setReply("回复");
        responseData.setDate(new Date());
        int i = responseMapper.insertResponse(responseData);
        System.out.println(i);
    }

    @Test
    public void deleteByid() {
        int i = responseMapper.deleteByid(1);
    }
    @Test
    public void queryAll(){
        ResponseData responseData = responseMapper.queryById(1);
        System.out.println(responseData);
    }
    @Test
    public void updateAll(){
        ResponseData responseData = new ResponseData();
        responseData.setResponseId(1);
        responseData.setCommentId(1);
        responseData.setRuserId("11122");
        responseData.setReply("更新回复测试");
        responseData.setDate(new Date());
        int i = responseMapper.updateAll(responseData);
        System.out.println(i);
    }
}