package com.eric.service.impl;

import com.eric.mapper.ResponseMapper;
import com.eric.pojo.ResponseData;
import com.eric.service.ResponseService;
import com.eric.vo.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    public ResponseMapper responseMapper;
//    @Autowired
//    public IdWorker idWorker;

    public static final String salt = "dadadafdafaUJM(O0";

    @Override
    public int insertResponseDate(UserResponse userResponse) {
        ResponseData responseData = new ResponseData();
        BeanUtils.copyProperties(userResponse,responseData);
        Long saltId = Long.valueOf(userResponse.getRuserId());
        Long saltRid = Long.valueOf(userResponse.getCommentId());

        int id = userResponse.getCommentId();
        responseData.setResponseId((int) id);
        int i = responseMapper.insertResponse(responseData);
        return (int) id;
    }

    @Override
    public ResponseData queryResponseDate(int responseId) {
        ResponseData responseData = responseMapper.queryById(responseId);
        return responseData;
    }

    @Override
    public int deleteAll(int responseId) {
        return responseMapper.deleteByid(responseId);
    }
}
