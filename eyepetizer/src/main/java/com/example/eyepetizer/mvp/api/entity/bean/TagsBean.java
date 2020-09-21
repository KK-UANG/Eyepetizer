package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class TagsBean  implements Serializable {

    private int id;
    private String name;
    private String actionUrl;
    private Object adTrack;
    private String desc;
    private String bgPicture;
    private String headerImage;
    private String tagRecType;
    private Object childTagList;
    private Object childTagIdList;
    private boolean haveReward;
    private boolean ifNewest;
    private Object newestEndTime;
    private int communityIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public Object getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(Object adTrack) {
        this.adTrack = adTrack;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getBgPicture() {
        return bgPicture;
    }

    public void setBgPicture(String bgPicture) {
        this.bgPicture = bgPicture;
    }

    public String getHeaderImage() {
        return headerImage;
    }

    public void setHeaderImage(String headerImage) {
        this.headerImage = headerImage;
    }

    public String getTagRecType() {
        return tagRecType;
    }

    public void setTagRecType(String tagRecType) {
        this.tagRecType = tagRecType;
    }

    public Object getChildTagList() {
        return childTagList;
    }

    public void setChildTagList(Object childTagList) {
        this.childTagList = childTagList;
    }

    public Object getChildTagIdList() {
        return childTagIdList;
    }

    public void setChildTagIdList(Object childTagIdList) {
        this.childTagIdList = childTagIdList;
    }

    public boolean isHaveReward() {
        return haveReward;
    }

    public void setHaveReward(boolean haveReward) {
        this.haveReward = haveReward;
    }

    public boolean isIfNewest() {
        return ifNewest;
    }

    public void setIfNewest(boolean ifNewest) {
        this.ifNewest = ifNewest;
    }

    public Object getNewestEndTime() {
        return newestEndTime;
    }

    public void setNewestEndTime(Object newestEndTime) {
        this.newestEndTime = newestEndTime;
    }

    public int getCommunityIndex() {
        return communityIndex;
    }

    public void setCommunityIndex(int communityIndex) {
        this.communityIndex = communityIndex;
    }
}
