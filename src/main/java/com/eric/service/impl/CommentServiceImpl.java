package com.eric.service.impl;

import com.eric.mapper.CommentMapper;
import com.eric.pojo.CommetData;
import com.eric.service.CommentService;
import com.eric.vo.CommentVo;
import com.eric.vo.UserComment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public CommentVo createComment(UserComment userComment){
        CommetData commetData = new CommetData();

        //通过用户id生成唯一的帖子ID
        Long userid = Long.getLong(userComment.getUserid());

        long commentid = userid;
        //强转long->int
        BeanUtils.copyProperties(userComment,commetData);
        commetData.setCommentId((int) commentid);
        int flags = commentMapper.insertComment(commetData);
//        try {
//           flags =  commentMapper.insertComment(commetData);
//        }catch (Exception e){
//            System.out.println("创建帖子失败");
//            throw new Exception();
//        }
        CommentVo commentVo = UserCom2ComVo(commetData);
        return commentVo;
    }

    @Override
    public int deleteComment(int commentId) {
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
