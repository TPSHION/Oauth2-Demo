package com.tpshion.oauth2.demo.config.exception;

import com.tpshion.oauth2.demo.config.response.RespStatus;
import lombok.Data;

@Data
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 异常状态码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String msg;

    /**
     * 使用自定义枚举初始化
     * @param respStatus
     */
    public MyException(RespStatus respStatus){
        this.code = respStatus.getCode();
        this.msg = respStatus.getMsg();
    }

    public MyException(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
