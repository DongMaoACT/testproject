package com.eric.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * VO：view Object视图对象
 * userComment
 * 当用户创建帖子时向后端传递需要自身ID,title,content,type,date
 * 帖子自身唯一ID由雪花算法生成
 */

public class UserComment {
    private String cuserid;
    private String title;
    private String content;
    private String type;
    private Date date;

    public String getUserid() {
        return cuserid;
    }

    public void setUserid(String userid) {
        this.cuserid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
