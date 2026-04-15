package com.example.demo.controller;
import com.github.pagehelper.PageInfo;
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 查询全部
    @GetMapping("/list")
    public List<User> list() {
        int a =1/0;
        return userService.getAllUsers();
    }

    // 新增
    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        return result > 0 ? "新增成功" : "新增失败";
    }



    // 🔥 分页接口
    @GetMapping("/page")
    public Result<?> page(int pageNum, int pageSize) {
        return Result.success(userService.page(pageNum, pageSize));
    }
    @PostMapping("/login")
    public Result<String> login(@RequestBody @Valid User user) {
        User loginUser = userService.login(user.getUsername(), user.getPassword());
        String token = JwtUtil.createToken(loginUser);
        return Result.success(token);
    }
}