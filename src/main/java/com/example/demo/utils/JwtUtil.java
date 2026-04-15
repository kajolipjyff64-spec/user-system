package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.entity.User;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET = "abc123456";

    // 过期时间：1小时
    private static final long EXPIRE_TIME = 60 * 60 * 1000;

    // 生成 token
    public static String createToken(User user) {
        return JWT.create()
                .withClaim("username", user.getUsername())
                .withIssuedAt(new Date()) // 签发时间
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .sign(Algorithm.HMAC256(SECRET));
    }

    // 校验并解析 token
    public static String parseToken(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getClaim("username")
                .asString();
    }
}