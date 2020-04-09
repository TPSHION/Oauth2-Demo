package com.tpshion.oauth2.demo.config.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 全局返回实体
 * @param
 */
@Data
@ToString
@NoArgsConstructor
@Slf4j
public class Result<T> implements Serializable {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述信息
     */
    private String msg;

    /**
     * 数据体
     */
    private T data;

    /**
     * 时间戳
     */
    private Long timestamp = System.currentTimeMillis();

    public Result(Integer code, T data){
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(RespStatus respStatus, T data){
        this.code = respStatus.getCode();
        this.msg = respStatus.getMsg();
        this.data = data;
    }

    public Result(RespStatus respStatus){
        this.code = respStatus.getCode();
        this.msg = respStatus.getMsg();
    }

    public static <T> Result<T> ok(T data){
        Result<T> result = new Result<T>();
        result.setCode(RespStatus.OK.getCode());
        result.setMsg(RespStatus.OK.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> Result<T> build(RespStatus respStatus, T data){
        return new Result<T>(respStatus,data);
    }

    /**
     * 转为json字符串
     * @return
     */
    public String toJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        String res = "";
        try {
            res = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("转换json字符串异常",e);
            e.printStackTrace();
        }
        return res;
    }

}
