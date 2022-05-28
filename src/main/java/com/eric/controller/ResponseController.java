package com.eric.controller;

import com.eric.service.ResponseService;
import com.eric.vo.ResponseVo;
import com.eric.vo.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/response")
public class ResponseController {
    /**
     *
     * @param userResponse
     */
    @Autowired
    public ResponseService responseService;

    /**
     *
     *
     * @param userResponse 前端返回生成评论必要信息
     * @return 返回有用户昵称和头像的评论
     */
    @RequestMapping("/create")
    public ResponseVo createResponse(UserResponse userResponse){
        ResponseVo responseVo = responseService.insertResponseDate(userResponse);
        return responseVo;
    }

    @RequestMapping("/{commentid}")
    public List<ResponseVo> getResponseByComId(@RequestParam("commentid") Long commentid){
        return responseService.queryAllByCommentId(commentid);
    }
    @RequestMapping("/delete/{responseid}")
    public int deleteResponse(@RequestParam("responseid")Long responseid){
        return responseService.deleteAll(responseid);
    }


}
