package com.eric.vo;

import java.util.Date;

public class ResponseVo {
    private Long responseId;
    private String name;//用户昵称
    private Byte portrait;//用户头像
    private int ruserId;
    private int commentId;
    private String reply;
    private Date date;

    @Override
    public String toString() {
        return "ResponseVo{" +
                "responseId=" + responseId +
                ", name='" + name + '\'' +
                ", portrait=" + portrait +
                ", ruserId='" + ruserId + '\'' +
                ", commentId=" + commentId +
                ", reply='" + reply + '\'' +
                ", date=" + date +
                '}';
    }

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getPortrait() {
        return portrait;
    }

    public void setPortrait(Byte portrait) {
        this.portrait = portrait;
    }

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
