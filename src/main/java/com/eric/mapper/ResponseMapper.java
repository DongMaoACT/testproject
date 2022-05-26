package com.eric.mapper;

import com.eric.pojo.ResponseData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResponseMapper {
    public int insertResponse(ResponseData responseData);

    public int deleteByid(@Param("id")Long responseId);

    public ResponseData queryById(@Param("id")int responseId);

    public int updateAll(ResponseData responseData);

    public List<ResponseData> queryByCommentId(@Param("comId")int commentId);
}
