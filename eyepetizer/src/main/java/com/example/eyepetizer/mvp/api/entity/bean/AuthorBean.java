package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class AuthorBean  implements Serializable {

    private int id;
    private String icon;
    private String name;
    private String description;
    private String link;
    private long latestReleaseTime;
    private int videoNum;
    private Object adTrack;
    private FollowBean follow;
    private ShieldBean shield;
    private int approvedNotReadyVideoCount;
    private boolean ifPgc;
    private int recSort;
    private boolean expert;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public long getLatestReleaseTime() {
        return latestReleaseTime;
    }

    public void setLatestReleaseTime(long latestReleaseTime) {
        this.latestReleaseTime = latestReleaseTime;
    }

    public int getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(int videoNum) {
        this.videoNum = videoNum;
    }

    public Object getAdTrack() {
        return adTrack;
    }

    public void setAdTrack(Object adTrack) {
        this.adTrack = adTrack;
    }

    public FollowBean getFollow() {
        return follow;
    }

    public void setFollow(FollowBean follow) {
        this.follow = follow;
    }

    public ShieldBean getShield() {
        return shield;
    }

    public void setShield(ShieldBean shield) {
        this.shield = shield;
    }

    public int getApprovedNotReadyVideoCount() {
        return approvedNotReadyVideoCount;
    }

    public void setApprovedNotReadyVideoCount(int approvedNotReadyVideoCount) {
        this.approvedNotReadyVideoCount = approvedNotReadyVideoCount;
    }

    public boolean isIfPgc() {
        return ifPgc;
    }

    public void setIfPgc(boolean ifPgc) {
        this.ifPgc = ifPgc;
    }

    public int getRecSort() {
        return recSort;
    }

    public void setRecSort(int recSort) {
        this.recSort = recSort;
    }

    public boolean isExpert() {
        return expert;
    }

    public void setExpert(boolean expert) {
        this.expert = expert;
    }

    private class FollowBean {
        private String itemType;
        private int itemId;
        private boolean followed;

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public boolean isFollowed() {
            return followed;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }
    }

    private class ShieldBean {
        private String itemType;
        private int itemId;
        private boolean shielded;

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public boolean isShielded() {
            return shielded;
        }

        public void setShielded(boolean shielded) {
            this.shielded = shielded;
        }
    }
}
