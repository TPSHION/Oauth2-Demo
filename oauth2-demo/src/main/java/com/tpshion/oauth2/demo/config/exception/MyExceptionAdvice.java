package com.tpshion.oauth2.demo.config.exception;

import com.tpshion.oauth2.demo.config.response.RespStatus;
import com.tpshion.oauth2.demo.config.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class MyExceptionAdvice {

    /**
     * 500异常处理(其他异常默认500处理)
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result defaultException(Exception e){
        Result result = null;
        if(e instanceof AccessDeniedException){
            //没有访问权限异常
            result = new Result(RespStatus.AccessDenied);
        } else if(e instanceof InvalidGrantException){
            result = new Result(RespStatus.UserError,e.getMessage());
        } else{
            result = new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
        }
        return result;
    }

    /**
     * 404异常处理
     */
//    @ExceptionHandler(value = NoHandlerFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public Result errorHandler(NoHandlerFoundException e) {
//        return new Result(HttpStatus.NOT_FOUND.value(), e.getMessage());
//    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result myHandler(MyException e){
        return new Result(e.getCode(),e.getMsg());
    }
}
