package com.eric.mapper;

import com.eric.pojo.UserSign;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "/applicationContext.xml")
public class UserSignMapperTest {
    @Autowired
    public UserSignMapper userSignMapper;
    @Test
    public void insertQuery() {
        int i = userSignMapper.insertQuery(1, 202205L);
        System.out.println(i);
    }

    @Test
    public void updateSign() {
        UserSign userSign = new UserSign();
        userSign.setUserid(1);
        Date date = new Date();
//        int year = date.getYear();
//        int month = date.getMonth();
//        StringBuilder stringBuilder = new StringBuilder();
//        String string = stringBuilder.append(year).append(month).toString();
//        System.out.println(string);
        userSign.setTimeStamp(202205L);
        userSign.setSignInSheet("100000000000000000000000000000");
        userSignMapper.updateSign(userSign);
//        int year = date.getYear();
//        int month = date.getMonth();
//        System.out.println(year);
//        System.out.println(month);
//        System.out.println(date);

    }

    @Test
    public void queryByid() {
        String s = userSignMapper.queryByid(1, 202205L);
        System.out.println(s);
    }
    @Test
    public void sign(){
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
//        System.out.println(simpleDateFormat.format(date));
//        System.out.println(Long.valueOf(simpleDateFormat.format(date)));
//        Date date = new Date();
//        SimpleDateFormat mm = new SimpleDateFormat("dd");
//        System.out.println(mm.format(date));
        String sheet = "00000000000000000000000000000000000000000";
        Date date = new Date();
        SimpleDateFormat mm = new SimpleDateFormat("dd");
        char[] chars = sheet.toCharArray();
        String s = mm.format(date).toString();
        Integer integer = Integer.valueOf(s);
        chars[integer-1] = '1';
        System.out.println(new String(chars));
    }

}