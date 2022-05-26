package com.eric.mapper;

import com.eric.pojo.UserSign;
import org.apache.ibatis.annotations.Param;


public interface UserSignMapper {
    /***
     * 实验思路：
     * 通过用户id和时间作为主键查询
     */
    public int insertQuery(@Param("id") int userid, @Param("stamp") Long timeStamp);

    public int updateSign(UserSign userSign);

    /**
     * 判断用户当前月份是否有记录
     * @param userid
     * @param timeStamp
     * @return
     */
    public String queryByid(@Param("id") int userid, @Param("stamp") Long timeStamp);



}
