package com.zw.activitidemo.common;

import java.io.Serializable;
import java.text.MessageFormat;

public class ResponseMsg<T> implements Serializable {
    private int code;
    private T data;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private ResponseMsg(Integer code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder<T> {
        private Integer code = 200;
        private String  desc = "成功";
        private T       data;

        public Builder() {
        }

        public Builder baseResponse(ResultCode resultCode) {
            this.code = resultCode.getResultCode();
            this.desc = resultCode.getDesc();
            return this;
        }

        public Builder baseResponse(ResultCode resultCode, Object... objs) {
            this.code = resultCode.getResultCode();
            this.desc = MessageFormat.format(resultCode.getDesc(), objs);
            return this;
        }

        public Builder baseResponse(Integer code, String message) {
            this.code = code;
            this.desc = message;
            return this;
        }

        public Builder result(T data) {
            this.data = data;
            return this;
        }

        public ResponseMsg build() {
            return new ResponseMsg(this.code, this.desc, this.data);
        }
    }
    @Override
    public String toString() {
        return "ResponseMsg{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
