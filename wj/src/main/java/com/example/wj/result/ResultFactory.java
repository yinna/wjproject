package com.example.wj.result;

public class ResultFactory {
    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.Success, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.Failure, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.getCode(), message, data);
    }

    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}
