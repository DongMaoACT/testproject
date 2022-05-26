package com.eric.service;

public interface UserSignService {
    /**
     * 签到功能：当当月未签到自动创建当前月份签到表
     * 通过string记录当前月份的具体签到日期
     * @return 返回当月签到天数
     * @param userid 用户id
     */
    public int updateSign(int userid);

    /**
     * 通过用户ID查询当前月份签到总天数
     * @param userid
     * @return
     */
    public int getSignSum(int userid);
}
