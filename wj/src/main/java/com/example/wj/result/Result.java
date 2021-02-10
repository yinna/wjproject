package com.example.wj.result;

public class Result {
    private int code;
    private String msg;
    private Object object;

    public Result(int code, String message, Object data){
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public int getCode(){
        return code;
    }
    public String getMsg(){
        return msg;
    }
    public Object getObject(){
        return object;
    }

    public void setCode(int code){
        this.code = code;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public void setObject(Object object){
        this.object = object;
    }
}
