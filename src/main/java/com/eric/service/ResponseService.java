package com.eric.service;

import com.eric.pojo.ResponseData;
import com.eric.vo.UserResponse;

public interface ResponseService {

    public int insertResponseDate(UserResponse userResponse);

    public ResponseData queryResponseDate(int responseId);

    public int deleteAll(int responseId);


}
