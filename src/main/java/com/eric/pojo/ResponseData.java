package com.eric.pojo;

import java.util.Date;

public class ResponseData {
    private int responseId;
    private String ruserId;
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

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public String getRuserId() {
        return ruserId;
    }

    public void setRuserId(String ruserId) {
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
