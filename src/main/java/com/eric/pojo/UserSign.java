package com.eric.pojo;

public class UserSign {
    private int userid;
    private Long timeStamp;
    private String signInSheet;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSignInSheet() {
        return signInSheet;
    }

    public void setSignInSheet(String signInSheet) {
        this.signInSheet = signInSheet;
    }
}
