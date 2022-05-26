package com.eric.pojo;


import java.util.Date;

public class User {
    private Integer id;//主键id
    private String name;//用户昵称
    private String password;//用户密码
    private String email;//用户邮箱
    private Integer rank;//权限等级
    private String phone;//用户电话
    private String introduce;
    private Byte portrait;//用户头像
    private Date brith_date;//用户生日
    private Date registration_date;//用户注册日期
    private Integer grade;//用户分数
    private String location;//用户地点

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", rank=" + rank +
                ", phone='" + phone + '\'' +
                ", introduce='" + introduce + '\'' +
                ", portrait=" + portrait +
                ", brith_date='" + brith_date + '\'' +
                ", registration_date='" + registration_date + '\'' +
                ", grade=" + grade +
                ", location='" + location + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Byte getPortrait() {
        return portrait;
    }

    public void setPortrait(Byte portrait) {
        this.portrait = portrait;
    }

    public Date getBrith_date() {
        return brith_date;
    }

    public void setBrith_date(Date brith_date) {
        this.brith_date = brith_date;
    }

    public Date getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(Date registration_date) {
        this.registration_date = registration_date;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
