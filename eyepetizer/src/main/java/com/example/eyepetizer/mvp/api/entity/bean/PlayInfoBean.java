package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;
import java.util.List;

public class PlayInfoBean  implements Serializable {

    private int height;
    private int width;
    private String name;
    private String type;
    private String url;
    private List<UrlListBean> urlList;

    public class UrlListBean {
        private String name;
        private String url;
        private int size;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
