package com.eric.service;

import com.eric.pojo.ResponseData;
import com.eric.vo.ResponseVo;
import com.eric.vo.UserResponse;

import java.util.List;

public interface ResponseService {

    public ResponseVo insertResponseDate(UserResponse userResponse);

    public ResponseData queryResponseDate(int responseId);

    public int deleteAll(Long responseId);

    public List<ResponseVo> queryAllByCommentId(Long commentid);
}
