package com.eric.service.impl;

import com.eric.mapper.IUserMapper;
import com.eric.mapper.ResponseMapper;
import com.eric.pojo.ResponseData;
import com.eric.pojo.User;
import com.eric.service.ResponseService;
import com.eric.snowflake.SnowFlake;
import com.eric.vo.ResponseVo;
import com.eric.vo.UserResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResponseServiceImpl implements ResponseService {
    @Autowired
    public ResponseMapper responseMapper;
//    @Autowired
//    public IdWorker idWorker;

    @Autowired
    public IUserMapper userMapper;
    @Override
    public ResponseVo insertResponseDate(UserResponse userResponse) {
        ResponseVo responseVo = new ResponseVo();
        ResponseData responseData = new ResponseData();
        BeanUtils.copyProperties(userResponse,responseVo);
        BeanUtils.copyProperties(userResponse,responseData);
        //查询用户
        User user = userMapper.getUserById(userResponse.getRuserId());
        responseVo.setName(user.getName());
        responseVo.setPortrait(user.getPortrait());
        //生成唯一主键
        Long ruserId = Long.valueOf(userResponse.getRuserId());
        SnowFlake snowFlake = new SnowFlake(ruserId,ruserId,ruserId);
        Long responseId = snowFlake.nextId();
        System.out.println(responseId);
        //完善属性值
        responseVo.setResponseId(responseId);
        responseData.setResponseId(responseId);
        //更新数据库
        int i = responseMapper.insertResponse(responseData);
        return responseVo;
    }

    @Override
    public ResponseData queryResponseDate(int responseId) {
        ResponseData responseData = responseMapper.queryById(responseId);
        return responseData;
    }

    @Override
    public int deleteAll(Long responseId) {
        return responseMapper.deleteByid(responseId);
    }

    /***
     *
     * @param commentid 帖子ID
     * @return 帖子中全部回复
     */
    @Override
    public List<ResponseVo> queryAllByCommentId(Long commentid) {
        List<ResponseData> responseData = responseMapper.queryByCommentId(commentid);
        List<ResponseVo> responseVoList = new ArrayList<>();
        for(ResponseData r:responseData){
            responseVoList.add(resp2respVo(r));
        }
        return responseVoList;
    }

    /**
     *
     * @return将消息打包成带有用户昵称和头像的消息
     */
    private ResponseVo resp2respVo(ResponseData responseData){
        ResponseVo responseVo = new ResponseVo();
        BeanUtils.copyProperties(responseData,responseVo);
        User user = userMapper.getUserById(responseVo.getCommentId());
        responseVo.setName(user.getName());
        responseVo.setPortrait(user.getPortrait());
        return responseVo;
    }
}
