package com.example.eyepetizer.mvp.api.entity.bean;

import java.io.Serializable;

public class OwEnrBean  implements Serializable {
    /**
     * uid : 303002950
     * nickname : MWPreacher24
     * avatar : http://img.kaiyanapp.com/ba2011d67c007b43163476562f93bd13.jpeg?imageMogr2/quality/60/format/jpg
     * userType : NORMAL
     * ifPgc : false
     * description :
     * area : null
     * gender : male
     * registDate : 1562117993000
     * releaseDate : 1597323525000
     * cover : http://img.kaiyanapp.com/f3c5eea4914b5979656665d47987ec3c.jpeg?imageMogr2/quality/60/format/jpg
     * actionUrl : eyepetizer://pgc/detail/303002950/?title=MWPreacher24&userType=NORMAL&tabIndex=0
     * followed : false
     * limitVideoOpen : false
     * library : BLOCK
     * birthday : 583465951000
     * country : null
     * city : 上海市
     * university : null
     * job : 设计师
     * expert : false
     */

    private int uid;
    private String nickname;
    private String avatar;
    private String userType;
    private boolean ifPgc;
    private String description;
    private Object area;
    private String gender;
    private long registDate;
    private long releaseDate;
    private String cover;
    private String actionUrl;
    private boolean followed;
    private boolean limitVideoOpen;
    private String library;
    private long birthday;
    private Object country;
    private String city;
    private Object university;
    private String job;
    private boolean expert;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isIfPgc() {
        return ifPgc;
    }

    public void setIfPgc(boolean ifPgc) {
        this.ifPgc = ifPgc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getRegistDate() {
        return registDate;
    }

    public void setRegistDate(long registDate) {
        this.registDate = registDate;
    }

    public long getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(long releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public boolean isFollowed() {
        return followed;
    }

    public void setFollowed(boolean followed) {
        this.followed = followed;
    }

    public boolean isLimitVideoOpen() {
        return limitVideoOpen;
    }

    public void setLimitVideoOpen(boolean limitVideoOpen) {
        this.limitVideoOpen = limitVideoOpen;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public Object getCountry() {
        return country;
    }

    public void setCountry(Object country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Object getUniversity() {
        return university;
    }

    public void setUniversity(Object university) {
        this.university = university;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isExpert() {
        return expert;
    }

    public void setExpert(boolean expert) {
        this.expert = expert;
    }
}
