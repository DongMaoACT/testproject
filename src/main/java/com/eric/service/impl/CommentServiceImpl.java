package com.eric.service.impl;

import com.eric.mapper.CommentMapper;
import com.eric.pojo.CommetData;
import com.eric.service.CommentService;
import com.eric.snowflake.SnowFlake;
import com.eric.vo.CommentVo;
import com.eric.vo.UserComment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public CommentVo createComment(UserComment userComment){
        CommetData commetData = new CommetData();
        BeanUtils.copyProperties(userComment,commetData);

        int flags = commentMapper.insertComment(commetData);
        CommentVo commentVo = UserCom2ComVo(commetData);
        return commentVo;
    }

    @Override
    public int deleteComment(Long commentId) {
        int i = commentMapper.deleteById(commentId);
        return i;
    }

    @Override
    public int updateComment(CommetData commetData) {
        return commentMapper.updateAll(commetData);
    }

    @Override
    public CommentVo getComment() {
        return null;
    }

    private CommentVo UserCom2ComVo(CommetData commetData){
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(commetData,commentVo);
        return commentVo;
    }
}
