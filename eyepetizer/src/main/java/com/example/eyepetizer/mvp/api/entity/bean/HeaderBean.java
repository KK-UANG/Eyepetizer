package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class HeaderBean  implements Serializable {

    private int id;
    private String title;
    private String font;
    private Object subTitle;
    private Object subTitleFont;
    private String textAlign;
    private Object cover;
    private Object label;
    private String actionUrl;
    private Object labelList;
    private String rightText;
    private String icon;
    private String iconType;
    private long time;
    private boolean showHateVideo;
    private String followType;
    private int tagId;
    private Object tagName;
    private String issuerName;
    private boolean topShow;
    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isShowHateVideo() {
        return showHateVideo;
    }

    public void setShowHateVideo(boolean showHateVideo) {
        this.showHateVideo = showHateVideo;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public Object getTagName() {
        return tagName;
    }

    public void setTagName(Object tagName) {
        this.tagName = tagName;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public boolean isTopShow() {
        return topShow;
    }

    public void setTopShow(boolean topShow) {
        this.topShow = topShow;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Object getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(Object subTitle) {
        this.subTitle = subTitle;
    }

    public Object getSubTitleFont() {
        return subTitleFont;
    }

    public void setSubTitleFont(Object subTitleFont) {
        this.subTitleFont = subTitleFont;
    }

    public String getTextAlign() {
        return textAlign;
    }

    public void setTextAlign(String textAlign) {
        this.textAlign = textAlign;
    }

    public Object getCover() {
        return cover;
    }

    public void setCover(Object cover) {
        this.cover = cover;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Object getLabelList() {
        return labelList;
    }

    public void setLabelList(Object labelList) {
        this.labelList = labelList;
    }

    public String getRightText() {
        return rightText;
    }

    public void setRightText(String rightText) {
        this.rightText = rightText;
    }
}
