package com.eric.service.impl;

import com.eric.mapper.CommentMapper;
import com.eric.pojo.CommetData;
import com.eric.service.CommentService;
import com.eric.snowflake.IdWorker;
import com.eric.vo.UserComment;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public boolean createComment(UserComment userComment){
        CommetData commetData = new CommetData();
        BeanUtils.copyProperties(userComment,commetData);
        //通过用户id生成唯一的帖子ID
        Long userid = Long.getLong(userComment.getUserid());
        IdWorker idWorker = new IdWorker(userid,userid,userid);
        long l = idWorker.nextId();
        //强转long->int
        commetData.setCommentId((int) l);
        int flags = commentMapper.insertComment(commetData);
//        try {
//           flags =  commentMapper.insertComment(commetData);
//        }catch (Exception e){
//            System.out.println("创建帖子失败");
//            throw new Exception();
//        }
        return flags==0?false:true;
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
}
