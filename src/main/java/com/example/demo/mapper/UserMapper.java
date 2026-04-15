package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username = #{username}")
    User findByUsername(String username);   // 👈 必须在接口里面

    @Insert("INSERT INTO user(username, password, age, email) VALUES(#{username}, #{password}, #{age}, #{email})")
    int insert(User user);

    @Select("SELECT * FROM user")
    List<User> findAll();
}