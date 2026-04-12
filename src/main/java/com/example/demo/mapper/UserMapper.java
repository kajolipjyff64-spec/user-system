package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(username, password, age, email) VALUES(#{username}, #{password}, #{age}, #{email})")
    int insert(User user);

    @Select("SELECT * FROM user")
    List<User> findAll();   // 👈 必须有这个
}