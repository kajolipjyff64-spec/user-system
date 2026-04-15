# 用户管理系统（Spring Boot）

## 📌 项目简介
本项目是一个基于 Spring Boot 的用户管理系统，实现了用户注册、登录、分页查询等基础功能，并结合 JWT 实现登录认证，具备完整的后端开发基础能力。

---

## 🛠 技术栈

- Java 8
- Spring Boot
- MyBatis
- MySQL
- JWT（登录认证）
- PageHelper（分页）
- Maven
- Lombok

---

## ✨ 功能模块

### 🔐 登录认证
- 使用 JWT 实现无状态登录认证
- 登录成功返回 token
- 通过拦截器进行接口鉴权

### 👤 用户管理
- 用户注册（新增用户）
- 用户登录
- 查询用户列表

### 📄 分页查询
- 使用 PageHelper 实现数据库分页
- 支持 pageNum / pageSize 参数

### ⚠️ 异常处理
- 全局异常处理（@RestControllerAdvice）
- 自定义异常（CustomException）
- 统一错误返回

### ✅ 参数校验
- 使用 @Valid + @NotBlank 实现参数校验
- 非法参数自动拦截

### 🔒 密码加密
- 使用 MD5 对密码加密存储
- 登录时进行加密比对

### 📦 统一返回格式
- 封装 Result 类，统一接口返回结构

---

## 📂 项目结构
com.example.demo
├── controller // 控制层
├── service // 业务层
├── mapper // 数据访问层
├── entity // 实体类
├── config // 配置类
├── interceptor // 拦截器
├── exception // 异常处理
├── util // 工具类
└── common // 通用返回类