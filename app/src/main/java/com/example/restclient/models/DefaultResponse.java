package com.example.restclient.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    @SerializedName("error")
    private boolean err;

    @SerializedName("message")
    private String msg;

    public DefaultResponse(boolean err, String msg) {
        this.err = err;
        this.msg = msg;
    }

    public boolean isErr() {
        return err;
    }

    public void setErr(boolean err) {
        this.err = err;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
