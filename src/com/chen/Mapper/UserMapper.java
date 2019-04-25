package com.chen.Mapper;

import com.chen.po.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User findById(int id);

    List<User> findAll();

    List<User> findAllLimit(@Param("start") int start, @Param("pageSize") int pageSize);
}
