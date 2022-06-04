package com.eric.pojo;

public class UserResult {
    private User user;

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;

    public Integer getStatus() {
        return status;
    }
    public User getUser(){
        return this.user;
    }
    public void setUser(User user){
        this.user = user;
    }
}

