package com.lehu.swaggerdemo.controller;


import com.lehu.swaggerdemo.entity.two.ApiCodeEnum;
import com.lehu.swaggerdemo.entity.two.ApiResult;

public class BaseController {

    protected final <T> ApiResult success() {
        return new ApiResult<T>(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMessage());
    }

    protected final <T> ApiResult success(String message,final T data) {
        return new ApiResult<T>(ApiCodeEnum.SUCCESS.getCode(), message,data);
    }

    protected final <T> ApiResult<T> success(final T data) {
        return new ApiResult<>(ApiCodeEnum.SUCCESS.getCode(), ApiCodeEnum.SUCCESS.getMessage(), data);
    }

    protected final <T> ApiResult<T> PasswordError(final T data) {
        return new ApiResult<>(ApiCodeEnum.PASSWORD_ERRO.getCode(), ApiCodeEnum.PASSWORD_ERRO.getMessage(), data);
    }

    protected final <T> ApiResult<T> MaterialError(final T data) {
        return new ApiResult<>(ApiCodeEnum.MATERIAL_ERRO.getCode(), ApiCodeEnum.MATERIAL_ERRO.getMessage(), data);
    }


    protected final <T> ApiResult<T> noWxLogin() {
        return new ApiResult<>(ApiCodeEnum.NO_WX_LOGIN.getCode(), ApiCodeEnum.NO_WX_LOGIN.getMessage());
    }

    protected final <T> ApiResult<T> noWbLogin() {
        return new ApiResult<>(ApiCodeEnum.NO_WB_LOGIN.getCode(), ApiCodeEnum.NO_WB_LOGIN.getMessage());
    }

    protected final <T> ApiResult<T> isLogin(final T data) {
        return new ApiResult<>(ApiCodeEnum.IS_LOGIN.getCode(), ApiCodeEnum.IS_LOGIN.getMessage(), data);
    }

    protected final <T> ApiResult<T> failLogin(final T data) {
        return new ApiResult<>(ApiCodeEnum.FIAL_LOGIN.getCode(), ApiCodeEnum.FIAL_LOGIN.getMessage(), data);
    }

    protected final <T> ApiResult<T> error(final ApiCodeEnum apiCodeEnum, final T data) {
        return new ApiResult<>(apiCodeEnum.getCode(), apiCodeEnum.getMessage(), data);
    }

    protected final ApiResult error(final String msg) {
        return new ApiResult(ApiCodeEnum.DELECT.getCode(), msg, msg);
    }


    protected final <T> ApiResult<T> TOKEN_INVALID(T data) {
        return new ApiResult<T>(ApiCodeEnum.TOKEN_INVALID.getCode(), ApiCodeEnum.TOKEN_INVALID.getMessage(), data);
    }


    protected final <T> ApiResult<T> addPostSuccess(String message) {
        return new ApiResult<>(200, message, null);
    }

    protected final <T> ApiResult<T> addObjectError(String message) {
        return new ApiResult<T>(500, message, null);
    }

    protected final <T> ApiResult<T> updatePostSuccess(String message) {
        return new ApiResult<>(200, message, null);
    }

    protected final <T> ApiResult<T> updateObjectError(String message) {
        return new ApiResult<T>(500, message, null);
    }

    protected final <T> ApiResult<T> deletePostSuccess(String message) {
        return new ApiResult<>(200, message, null);
    }

    protected final <T> ApiResult<T> deleteObjectError(String message) {
        return new ApiResult<T>(500, message, null);
    }

    protected final <T> ApiResult<T> ErrorDetail(String message) {
        return new ApiResult<T>(500, message, null);
    }

    protected final <T> ApiResult<T> updatePostError(String message) {
        return new ApiResult<>(500, message, null);
    }


}
