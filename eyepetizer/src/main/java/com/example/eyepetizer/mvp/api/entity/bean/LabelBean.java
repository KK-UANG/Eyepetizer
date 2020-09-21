package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class LabelBean  implements Serializable {

    private String text;
    private String card;
    private Object detail;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }
}
