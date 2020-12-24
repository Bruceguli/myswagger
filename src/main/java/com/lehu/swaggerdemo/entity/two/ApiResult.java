package com.lehu.swaggerdemo.entity.two;


import io.swagger.annotations.ApiModel;


public class ApiResult<T> {

    private Integer code;

    private String msg;
    private T data;
    private String expandKeys;

    public ApiResult() {

    }
    public ApiResult(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ApiResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

//    public ApiResult(AnyException anyException) {
//        this.code = anyException.getCode();
//        this.msg = anyException.getMessage();
//    }

    public ApiResult(ApiCodeEnum apiCodeEnum) {
        this.code = apiCodeEnum.getCode();
        this.msg = apiCodeEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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
    public String getExpandKeys() {
        return expandKeys;
    }

    public void setExpandKeys(String expandKeys) {
        this.expandKeys = expandKeys;
    }
    public ApiResult(Integer code, String msg, T data, String expandKeys) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.expandKeys = expandKeys;
    }
}
