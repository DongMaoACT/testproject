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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public CommentVo createComment(UserComment userComment){
        CommetData commetData = new CommetData();
        BeanUtils.copyProperties(userComment,commetData);
        /***
         * 获取唯一ID
         */
        String factorId = String.valueOf(userComment.getUserid())+String.valueOf(userComment.getUserid());
        SnowFlake snowFlake = new SnowFlake(Long.valueOf(factorId),Long.valueOf(factorId),Long.valueOf(factorId));
        Long commentId = snowFlake.nextId();
        commetData.setCommentId(commentId);
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

    @Override
    public List<CommentVo> getAllCommentByUserID(int userid) {
        List<CommetData> commetData = commentMapper.queryAllByUserId(userid);
        List<CommentVo> res = new ArrayList<>();
        for(CommetData date:commetData){
            res.add(UserCom2ComVo(date));
        }
        return res;
    }

    private CommentVo UserCom2ComVo(CommetData commetData){
        CommentVo commentVo = new CommentVo();
        BeanUtils.copyProperties(commetData,commentVo);
        return commentVo;
    }
}
