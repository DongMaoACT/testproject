package com.eric.service.impl;

import com.eric.mapper.UserSignMapper;
import com.eric.pojo.UserSign;
import com.eric.service.UserSignService;
import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserSignServiceImpl implements UserSignService {
    @Autowired
    public UserSignMapper userSignMapper;
    @Override
    public int updateSign(String userid) {
        String currentTime = getCurrentTime();
        /**
         * 当不存在时则创建记录
         */
        Long timeStamp = Long.valueOf(currentTime);
        String sheet = userSignMapper.queryByid(Integer.parseInt(userid), timeStamp);
        int totalNum = 0;
        if(sheet!=null){
            /**
             * 存在则判断当天在当前月的第几天
             * 修改签到
             */
            String updateSheet = updateSheet(sheet);
            UserSign userSign = new UserSign();
            userSign.setUserid(Integer.parseInt(userid));
            userSign.setTimeStamp(timeStamp);
            userSign.setSignInSheet(updateSheet);
            int sign = userSignMapper.updateSign(userSign);
            totalNum = getAllSignNum(updateSheet);
        }else {
            /**
             * 第一次签到创建记录
             */
            int firstSign = userSignMapper.insertQuery(Integer.parseInt(userid), timeStamp);
            totalNum = 1;
        }
        return totalNum;
    }
    private String getCurrentTime(){
        Date date = new Date();
        StringBuilder sb = new StringBuilder();
        String currentTime = sb.append(String.valueOf(date.getYear())+String.valueOf(date.getMonth())).toString();
        return currentTime.toString();
    }
    private String updateSheet(String sheet){
        Date date = new Date();
        int day = date.getDay();
        char[] charSheet = sheet.toCharArray();
        charSheet[day] = '1';
        return charSheet.toString();
    }
    private int getAllSignNum(String sheet){
        int result = 0;
        for(char a : sheet.toCharArray()){
            if (a == '1') {
                ++result;
            }
            }
        return result;
    }
}

