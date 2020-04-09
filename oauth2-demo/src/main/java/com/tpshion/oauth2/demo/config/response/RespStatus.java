package com.tpshion.oauth2.demo.config.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RespStatus {
    /**
     * 200~成功类型
     * 500~服务器异常
     * 400~访问异常
     * 600~业务异常
     */
    OK(200,"success"),
    ERROR(500,"服务器错误"),
    AccessDenied(403,"不允许访问"),
    TokenDenied(401,"没有访问权限"),
    TokenFail(4001,"无效token"),
    TokenMiss(4002,"token缺失"),
    NotMethod(404,"调用地址找不到"),
    UserError(500,"用户名或密码错误");

    private Integer code;
    private String msg;

}
