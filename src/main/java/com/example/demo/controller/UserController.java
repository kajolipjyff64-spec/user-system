package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> list() {
        return userService.getAllUsers();
    }
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        return result > 0 ? "新增成功" : "新增失败";
    }
}