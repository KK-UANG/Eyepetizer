package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class ConsumptionBean  implements Serializable {
    private int collectionCount;
    private int shareCount;
    private int replyCount;
    private int realCollectionCount;

    public int getCollectionCount() {
        return collectionCount;
    }

    public void setCollectionCount(int collectionCount) {
        this.collectionCount = collectionCount;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getRealCollectionCount() {
        return realCollectionCount;
    }

    public void setRealCollectionCount(int realCollectionCount) {
        this.realCollectionCount = realCollectionCount;
    }
}
