package com.example.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.exception.CustomException;
import com.example.demo.util.MD5Util;  // 👈 别忘了这个

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 查询全部
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    // 新增（🔥保留这个，加密版）
    public int addUser(User user) {
        user.setPassword(MD5Util.md5(user.getPassword()));
        return userMapper.insert(user);
    }

    // 分页
    public PageInfo<User> page(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.findAll();
        return new PageInfo<>(list);
    }

    // 登录（🔥加密对比）
    public User login(String username, String password) {

        User user = userMapper.findByUsername(username);

        if (user == null) {
            throw new CustomException("用户不存在");
        }

        // 🔥 输入密码也加密
        String md5Pwd = MD5Util.md5(password);

        if (!user.getPassword().equals(md5Pwd)) {
            throw new CustomException("密码错误");
        }

        return user;
    }
}