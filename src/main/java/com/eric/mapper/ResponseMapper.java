package com.eric.mapper;

import com.eric.pojo.ResponseData;
import org.apache.ibatis.annotations.Param;

public interface ResponseMapper {
    public int insertResponse(ResponseData responseData);

    public int deleteByid(@Param("id")int responseId);

    public ResponseData queryById(@Param("id")int responseId);

    public int updateAll(ResponseData responseData);
}
