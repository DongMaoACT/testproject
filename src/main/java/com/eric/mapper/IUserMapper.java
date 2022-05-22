package com.eric.mapper;

import com.eric.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface IUserMapper {
    User validateUser(@Param("id") String id, @Param("password") String password);
    void registerByUsernameAndPassword(@Param("id")String id,
                                       @Param("password")String password,
                                       @Param("name")String name);
}
