package com.eric.controller;

import com.eric.service.CommentService;
import com.eric.service.ResponseService;
import com.eric.vo.CommentVo;
import com.eric.vo.UserComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    public CommentService commentService;

    /**
     * 前端表单上传数据 可以通过类来接收参数
     * @param userComment
     * @return 返回带有标题内容时间帖子id的CommentVo
     */

    public CommentVo creatComment(UserComment userComment){
        CommentVo commentVo = commentService.createComment(userComment);
        return commentVo;
    }
    /**
     * 用户对自己的帖子进行操作
     * 1.查询到自己的帖子
     * 2.对自己的帖子进行增删改查
     */
    /**
     * 查询到有关帖子
     */
    @RequestMapping("/{userid}")
    public List<CommentVo> queryComment(@PathVariable("userid")String userid){
        return null;
    }
}
