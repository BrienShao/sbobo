package com.example.sbobo.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 啵啵
 * @date 2021/12/10
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 错误码
     */
    private String errCode;

    /**
     * 错误信息
     */
    private String errMsg;

    /**
     * 返回数据
     */
    private T module;

    //@Override
    //public String toString() {
    //    return "Result{" +
    //            "success=" + success +
    //            ", errCode='" + errCode + '\'' +
    //            ", errMsg='" + errMsg + '\'' +
    //            ", module=" + module +
    //            '}';
    //}

    public Result<T> success(T module) {
        this.setSuccess(true);
        this.setErrCode("0");
        this.setErrMsg("OK");
        this.setModule(module);
        return this;
    }

    public Result<T> error(String errCode, String errMsg) {
        this.setSuccess(false);
        this.setErrCode(errCode);
        this.setErrMsg(errMsg);
        return this;
    }

    public Result<T> error(String errMsg) {
        this.setSuccess(false);
        this.setErrCode("-1");
        this.setErrMsg(errMsg);
        return this;
    }
}
