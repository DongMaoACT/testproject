package com.eric.service;

import com.eric.vo.CommentVo;
import com.eric.vo.UserComment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CommentServiceTest {
    @Autowired
    public CommentService commentServicel;
    @Test
    public void createComment() {
        UserComment userComment = new UserComment();

        userComment.setUserid(1);
        userComment.setDate(new Date());
        userComment.setContent("测试");
        userComment.setTitle("测试");
        userComment.setContent("测试内容");

        CommentVo comment = commentServicel.createComment(userComment);
        System.out.println(comment);
    }

    @Test
    public void deleteComment() {
    }

    @Test
    public void updateComment() {
    }

    @Test
    public void getComment() {
    }
}