package com.eric.service;

import com.eric.pojo.CommetData;
import com.eric.vo.UserComment;

public interface CommentService {
    /**
     * 用户创建一个帖子 帖子的id通过雪花算法随机生成
     * @return
     */
    public boolean createComment(UserComment userComment);

    /**
     * 删除帖子
     * @param commentId
     * @return
     */
    public int deleteComment(int commentId);

    /**
     * 普通用户更新帖子
     * @param commetData
     * @return
     */
    public int updateComment(CommetData commetData);
}
