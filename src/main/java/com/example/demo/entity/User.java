package com.example.demo.entity;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import java.util.Date;

@Data
public class User {
    private Long id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    private Integer age;
    private String email;
    private Date createTime;
}