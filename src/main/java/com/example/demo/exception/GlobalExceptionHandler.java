package com.example.demo.exception;

import com.example.demo.common.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ① 系统异常
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        e.printStackTrace();
        return Result.error("系统异常");
    }

    // ② 自定义异常
    @ExceptionHandler(CustomException.class)
    public Result<?> handleCustomException(CustomException e) {
        return Result.error(e.getMessage());
    }

    // ③ 参数校验异常（🔥重点）
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<?> handleValidException(MethodArgumentNotValidException e) {
        String msg = e.getBindingResult().getFieldError().getDefaultMessage();
        return Result.error(msg);
    }
}