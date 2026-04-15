package com.example.demo.interceptor;

import com.example.demo.utils.JwtUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String token = request.getHeader("Authorization");

        if (token == null || token.isEmpty()) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"msg\":\"未登录\"}");
            return false;
        }

        try {
            JwtUtil.parseToken(token);
            return true;
        } catch (Exception e) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"code\":401,\"msg\":\"token无效\"}");
            return false;
        }
    }
}