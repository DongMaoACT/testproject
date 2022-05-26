package com.eric.service.impl;

import com.eric.mapper.UserSignMapper;
import com.eric.pojo.UserSign;
import com.eric.service.UserSignService;
//import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserSignServiceImpl implements UserSignService {
    @Autowired
    public UserSignMapper userSignMapper;
    @Override
    public int updateSign(int userid) {
        /**
         * 20XX XX的格式获取时间
         **/
        String currentTime = getCurrentTime();
        Long timeStamp = Long.valueOf(currentTime);
        /**
         * 当不存在时则创建记录
         */
        String sheet = userSignMapper.queryByid(userid, timeStamp);

        int totalNum = 0;
        if(sheet!=null){
            /**
             * 存在则判断当天在当前月的第几天
             * 修改签到
             */
            String updateSheet = updateSheet(sheet);

            UserSign userSign = new UserSign();
            userSign.setUserid(userid);
            userSign.setTimeStamp(timeStamp);
            userSign.setSignInSheet(updateSheet);

            int sign = userSignMapper.updateSign(userSign);

            totalNum = getAllSignNum(updateSheet);
        }else {
            /**
             * 第一次签到创建记录
             */
            int firstSign = userSignMapper.insertQuery(userid, timeStamp);
            totalNum = 1;
        }

        return totalNum;
    }

    /**
     * 返回当月全部签到天数
     * @param userid
     * @return
     */
    @Override
    public int getSignSum(int userid) {
        String s = userSignMapper.queryByid(userid, Long.valueOf(getCurrentTime()));
        int allSignNum = getAllSignNum(s);
        return allSignNum;
    }

    private String getCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        String format = simpleDateFormat.format(date);
        return  format;
    }

    /**
     *
     * @param sheet 传入更新前的
     * @return 返回更新后的签到表
     */
    private String updateSheet(String sheet){
        Date date = new Date();
        SimpleDateFormat mm = new SimpleDateFormat("dd");
        char[] chars = sheet.toCharArray();
        String s = mm.format(date).toString();
        Integer integer = Integer.valueOf(s);
        chars[integer-1] = '1';
        return new String(chars);
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

