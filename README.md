# 用户管理系统（Spring Boot + MyBatis）

## 项目介绍

基于 Spring Boot + MyBatis + MySQL 实现的用户管理系统，
包含用户的增删改查功能。

## 技术栈

* Spring Boot
* MyBatis
* MySQL

## 功能

* 查询用户
* 新增用户
* 修改用户
* 删除用户

## 启动方式

1. 导入数据库（sql 文件在 /sql 目录）
2. 修改 application.yml 数据库配置
3. 启动项目

## 接口

* GET /users
* POST /add
* PUT /update
* DELETE /delete/{id}
