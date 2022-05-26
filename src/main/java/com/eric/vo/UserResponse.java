package com.eric.vo;

import java.util.Date;

public class UserResponse {
    private int ruserId;
    private int commentId;
    private String reply;
    private Date date;

    public int getRuserId() {
        return ruserId;
    }

    public void setRuserId(int ruserId) {
        this.ruserId = ruserId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
