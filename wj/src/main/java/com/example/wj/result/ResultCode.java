package com.example.wj.result;

public enum ResultCode {
    Success(200,"ddd"),Failure(400,"400失败了哟");

    private int code;
    private String remark;

    ResultCode(int code, String remark){
        this.code = code;
        this.remark = remark;
    }

    public int getCode() {
        return code;
    }
    public String getRemark() {
        return remark;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static void main(String[] args) {
        int code = ResultCode.Success.getCode();
        String remark = ResultCode.Success.getRemark();
        System.out.println(code);
        System.out.println(remark);
    }
}

