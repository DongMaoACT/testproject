package com.eric.mapper;

import com.eric.pojo.CommetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CommentMapperTest {
    @Autowired
    private CommentMapper commentMapper;
    @Test
    public void insertComment() {
        CommetData commetData = new CommetData();

        commetData.setCuserId(1);
        commetData.setContent("这是第一条Comment测试");
        commetData.setTitle("第一条标题");
        commetData.setType("学习");
        commetData.setDate(new Date());
        int i = commentMapper.insertComment(commetData);
        System.out.println(i);
    }

    @Test
    public void deleteById() {
        int i = commentMapper.deleteById(2L);
        System.out.println(i);
    }

    @Test
    public void querybyId(){
        CommetData commetData = commentMapper.queryById(1L);
        System.out.println(commetData);
    }
    @Test
    public void updateAll(){
        CommetData commetData = new CommetData();

        commetData.setCuserId(1);
        commetData.setContent("修改测试");
        commetData.setTitle("标题修改");
        commetData.setType("学习");
        commetData.setDate(new Date());
        int i = commentMapper.updateAll(commetData);
        System.out.println(i);
    }
}