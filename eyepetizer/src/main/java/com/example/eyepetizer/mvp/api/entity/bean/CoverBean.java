package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class CoverBean  implements Serializable {

    private String feed;
    private String detail;
    private String blurred;
    private Object sharing;
    private String homepage;

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBlurred() {
        return blurred;
    }

    public void setBlurred(String blurred) {
        this.blurred = blurred;
    }

    public Object getSharing() {
        return sharing;
    }

    public void setSharing(Object sharing) {
        this.sharing = sharing;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }
}
