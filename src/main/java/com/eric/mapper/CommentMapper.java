package com.eric.mapper;

import com.eric.pojo.CommetData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    public int insertComment(CommetData commetData);

    public int deleteById(@Param("id")int id);

    public CommetData queryById(@Param("id") int id);

    public int updateAll(CommetData commetData);

    public List<CommetData> queryAll();
}