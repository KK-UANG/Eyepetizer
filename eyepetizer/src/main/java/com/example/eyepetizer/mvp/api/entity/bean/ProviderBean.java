package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class ProviderBean  implements Serializable {
    private String name;
    private String alias;
    private String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
