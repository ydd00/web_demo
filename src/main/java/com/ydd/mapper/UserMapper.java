package com.ydd.mapper;

import com.ydd.pojo.Brand;
import com.ydd.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User login(@Param("username") String username, @Param("password") String password);
    Integer addUser(@Param("username") String username, @Param("password") String password);
    User selectByName(String username);
}
