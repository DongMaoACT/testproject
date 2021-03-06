package com.eric.pojo;

import java.util.Date;

public class ResponseData {
    private Long responseId;
    private Integer ruserId;//主键id
    private int commentId;
    private String reply;
    private Date date;

    @Override
    public String toString() {
        return "ResponseData{" +
                "responseId=" + responseId +
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
