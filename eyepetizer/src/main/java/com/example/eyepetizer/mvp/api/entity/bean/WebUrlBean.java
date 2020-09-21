package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class WebUrlBean  implements Serializable {

    private String raw;
    private String forWeibo;

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getForWeibo() {
        return forWeibo;
    }

    public void setForWeibo(String forWeibo) {
        this.forWeibo = forWeibo;
    }
}
