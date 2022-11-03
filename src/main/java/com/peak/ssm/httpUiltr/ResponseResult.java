package com.peak.ssm.httpUiltr;

import java.io.Serializable;

import com.peak.ssm.uiltr.TokenTools;

/**
 * <b><code>ResponseResult</code></b>
 * <p>
 * Description响应信息主体
 * </p>
 * <b>Creation Time:</b> 2019/11/26 17:55.
 *
 * @author chensen
 * @since gempile-boiler-code 0.1.0
 */
public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private String type;

    private T data;

    private T token;



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getToken() {
        return token;
    }

    public void setToken(T token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ResponseResult() {
    }

    public ResponseResult(T data, int code, String msg, T token) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.token = token;
    }

    public ResponseResult(T data, int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResponseResult<T> ok() {
        return restResult(null, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc(),HttpEnum.OK_200.type());
    }

    public static <T> ResponseResult<T> ok(T data) {
        return restResult(data, HttpEnum.OK_200.code(), HttpEnum.OK_200.desc(),HttpEnum.OK_200.type());
    }

    public static <T> ResponseResult<T> ok(T data, String msg) {
        return restResult(data, HttpEnum.OK_200.code(), msg,HttpEnum.OK_200.type());
    }

    public static <T> ResponseResult<T> ok(T data, String msg,T token) {
        return restResult(data, HttpEnum.OK_200.code(), msg,HttpEnum.OK_200.type(),token);
    }

    public static <T> ResponseResult<T> failed() {
        return restResult(null, HttpEnum.ERROR_500.code(),HttpEnum.ERROR_500.desc(),HttpEnum.ERROR_500.type());
    }

    public static <T> ResponseResult<T> failed(String msg) {
        return restResult(null, HttpEnum.ERROR_500.code(), msg,HttpEnum.ERROR_500.type());
    }

    public static <T> ResponseResult<T> failed(int code, String msg,String type) {
        return restResult(null, code, msg, type);
    }

    public static <T> ResponseResult<T> failed(T data) {
        return restResult(data, HttpEnum.ERROR_500.code(), HttpEnum.ERROR_500.desc(),HttpEnum.ERROR_500.type());
    }

    public static <T> ResponseResult<T> failed(T data, String msg) {
        return restResult(data, HttpEnum.ERROR_500.code(), msg, HttpEnum.ERROR_500.type());
    }

    private static <T> ResponseResult<T> restResult(T data, int code, String msg,String type) {
        ResponseResult<T> apiResult = new ResponseResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setType(type);
        return apiResult;
    }

    private static <T> ResponseResult<T> restResult(T data, int code, String msg,String type,T token) {
        ResponseResult<T> apiResult = new ResponseResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        apiResult.setType(type);
        apiResult.setToken(token);
        return apiResult;
    }

}