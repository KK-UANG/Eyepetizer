package com.example.eyepetizer.mvp.api.entity.bean;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class ItemListBean implements Serializable {

    private String type;
    private DataBean data;
    private Object tag;
    private int id;
    private int adIndex;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public Object getTag() {
        return tag;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdIndex() {
        return adIndex;
    }

    public void setAdIndex(int adIndex) {
        this.adIndex = adIndex;
    }

    public class DataBean implements Serializable {

        private String dataType;
        private int id;
        private String title;
        private String description;
        private String image;
        private String actionUrl;
        private boolean shade;
        private LabelBean label;
        private HeaderBean header;
        private boolean autoPlay;
        private List<?> adTrack;
        private List<?> labelList;
        private int count;
        private List<ItemListBean> itemList;
        private Object footer;
        private String type;
        private String text;
        private String subTitle;
        private Object follow;
        private String rightText;
        private String library;
        private ConsumptionBean consumption;
        private String resourceType;
        private Object slogan;
        private ProviderBean provider;
        private String category;
        private AuthorBean author;
        private CoverBean cover;
        private String playUrl;
        private Object thumbPlayUrl;
        private int duration;
        private WebUrlBean webUrl;
        private long releaseTime;
        private Object campaign;
        private Object waterMarks;
        private boolean ad;
        private Object titlePgc;
        private Object descriptionPgc;
        private Object remark;
        private boolean ifLimitVideo;
        private int searchWeight;
        private Object brandWebsiteInfo;
        private Object videoPosterBean;
        private int idx;
        private Object shareAdTrack;
        private Object favoriteAdTrack;
        private Object webAdTrack;
        private long date;
        private Object promotion;
        private String descriptionEditor;
        private boolean collected;
        private boolean reallyCollected;
        private boolean played;
        private Object lastViewTime;
        private Object playlists;
        private Object src;
        private Object recallSource;
        private Object recall_source;
        private List<TagsBean> tags;
        private List<PlayInfoBean> playInfo;
        private List<?> subtitles;
        private String icon;
        private ItemListBean content;
        private String backgroundImage;
        private List<String> titleList;
        private String nickname;
        private String url;
        private String userCover;
        private List<String> urls;
        private String bgPicture;
        private int width;
        private int height;
        private String issuerName;

        public String getIssuerName() {
            return issuerName;
        }

        public void setIssuerName(String issuerName) {
            this.issuerName = issuerName;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        private OwEnrBean owner;

        public OwEnrBean getOwner() {
            return owner;
        }

        public void setOwner(OwEnrBean owner) {
            this.owner = owner;
        }

        public String getBgPicture() {
            return bgPicture;
        }

        public void setBgPicture(String bgPicture) {
            this.bgPicture = bgPicture;
        }

        public List<String> getUrls() {
            return urls;
        }

        public void setUrls(List<String> urls) {
            this.urls = urls;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUserCover() {
            return userCover;
        }

        public void setUserCover(String userCover) {
            this.userCover = userCover;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public List<String> getTitleList() {
            return titleList;
        }

        public void setTitleList(List<String> titleList) {
            this.titleList = titleList;
        }

        public String getBackgroundImage() {
            return backgroundImage;
        }

        public void setBackgroundImage(String backgroundImage) {
            this.backgroundImage = backgroundImage;
        }

        public ItemListBean getContent() {
            return content;
        }

        public void setContent(ItemListBean content) {
            this.content = content;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getActionUrl() {
            return actionUrl;
        }

        public void setActionUrl(String actionUrl) {
            this.actionUrl = actionUrl;
        }

        public boolean isShade() {
            return shade;
        }

        public void setShade(boolean shade) {
            this.shade = shade;
        }

        public LabelBean getLabel() {
            return label;
        }

        public void setLabel(LabelBean label) {
            this.label = label;
        }

        public HeaderBean getHeader() {
            return header;
        }

        public void setHeader(HeaderBean header) {
            this.header = header;
        }

        public boolean isAutoPlay() {
            return autoPlay;
        }

        public void setAutoPlay(boolean autoPlay) {
            this.autoPlay = autoPlay;
        }

        public List<?> getAdTrack() {
            return adTrack;
        }

        public void setAdTrack(List<?> adTrack) {
            this.adTrack = adTrack;
        }

        public List<?> getLabelList() {
            return labelList;
        }

        public void setLabelList(List<?> labelList) {
            this.labelList = labelList;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public Object getFooter() {
            return footer;
        }

        public void setFooter(Object footer) {
            this.footer = footer;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public String getRightText() {
            return rightText;
        }

        public void setRightText(String rightText) {
            this.rightText = rightText;
        }

        public String getLibrary() {
            return library;
        }

        public void setLibrary(String library) {
            this.library = library;
        }

        public ConsumptionBean getConsumption() {
            return consumption;
        }

        public void setConsumption(ConsumptionBean consumption) {
            this.consumption = consumption;
        }

        public String getResourceType() {
            return resourceType;
        }

        public void setResourceType(String resourceType) {
            this.resourceType = resourceType;
        }

        public Object getSlogan() {
            return slogan;
        }

        public void setSlogan(Object slogan) {
            this.slogan = slogan;
        }

        public ProviderBean getProvider() {
            return provider;
        }

        public void setProvider(ProviderBean provider) {
            this.provider = provider;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public AuthorBean getAuthor() {
            return author;
        }

        public void setAuthor(AuthorBean author) {
            this.author = author;
        }

        public CoverBean getCover() {
            return cover;
        }

        public void setCover(CoverBean cover) {
            this.cover = cover;
        }

        public String getPlayUrl() {
            return playUrl;
        }

        public void setPlayUrl(String playUrl) {
            this.playUrl = playUrl;
        }

        public Object getThumbPlayUrl() {
            return thumbPlayUrl;
        }

        public void setThumbPlayUrl(Object thumbPlayUrl) {
            this.thumbPlayUrl = thumbPlayUrl;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public WebUrlBean getWebUrl() {
            return webUrl;
        }

        public void setWebUrl(WebUrlBean webUrl) {
            this.webUrl = webUrl;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public Object getCampaign() {
            return campaign;
        }

        public void setCampaign(Object campaign) {
            this.campaign = campaign;
        }

        public Object getWaterMarks() {
            return waterMarks;
        }

        public void setWaterMarks(Object waterMarks) {
            this.waterMarks = waterMarks;
        }

        public boolean isAd() {
            return ad;
        }

        public void setAd(boolean ad) {
            this.ad = ad;
        }

        public Object getTitlePgc() {
            return titlePgc;
        }

        public void setTitlePgc(Object titlePgc) {
            this.titlePgc = titlePgc;
        }

        public Object getDescriptionPgc() {
            return descriptionPgc;
        }

        public void setDescriptionPgc(Object descriptionPgc) {
            this.descriptionPgc = descriptionPgc;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public boolean isIfLimitVideo() {
            return ifLimitVideo;
        }

        public void setIfLimitVideo(boolean ifLimitVideo) {
            this.ifLimitVideo = ifLimitVideo;
        }

        public int getSearchWeight() {
            return searchWeight;
        }

        public void setSearchWeight(int searchWeight) {
            this.searchWeight = searchWeight;
        }

        public Object getBrandWebsiteInfo() {
            return brandWebsiteInfo;
        }

        public void setBrandWebsiteInfo(Object brandWebsiteInfo) {
            this.brandWebsiteInfo = brandWebsiteInfo;
        }

        public Object getVideoPosterBean() {
            return videoPosterBean;
        }

        public void setVideoPosterBean(Object videoPosterBean) {
            this.videoPosterBean = videoPosterBean;
        }

        public int getIdx() {
            return idx;
        }

        public void setIdx(int idx) {
            this.idx = idx;
        }

        public Object getShareAdTrack() {
            return shareAdTrack;
        }

        public void setShareAdTrack(Object shareAdTrack) {
            this.shareAdTrack = shareAdTrack;
        }

        public Object getFavoriteAdTrack() {
            return favoriteAdTrack;
        }

        public void setFavoriteAdTrack(Object favoriteAdTrack) {
            this.favoriteAdTrack = favoriteAdTrack;
        }

        public Object getWebAdTrack() {
            return webAdTrack;
        }

        public void setWebAdTrack(Object webAdTrack) {
            this.webAdTrack = webAdTrack;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public Object getPromotion() {
            return promotion;
        }

        public void setPromotion(Object promotion) {
            this.promotion = promotion;
        }

        public String getDescriptionEditor() {
            return descriptionEditor;
        }

        public void setDescriptionEditor(String descriptionEditor) {
            this.descriptionEditor = descriptionEditor;
        }

        public boolean isCollected() {
            return collected;
        }

        public void setCollected(boolean collected) {
            this.collected = collected;
        }

        public boolean isReallyCollected() {
            return reallyCollected;
        }

        public void setReallyCollected(boolean reallyCollected) {
            this.reallyCollected = reallyCollected;
        }

        public boolean isPlayed() {
            return played;
        }

        public void setPlayed(boolean played) {
            this.played = played;
        }

        public Object getLastViewTime() {
            return lastViewTime;
        }

        public void setLastViewTime(Object lastViewTime) {
            this.lastViewTime = lastViewTime;
        }

        public Object getPlaylists() {
            return playlists;
        }

        public void setPlaylists(Object playlists) {
            this.playlists = playlists;
        }

        public Object getSrc() {
            return src;
        }

        public void setSrc(Object src) {
            this.src = src;
        }

        public Object getRecallSource() {
            return recallSource;
        }

        public void setRecallSource(Object recallSource) {
            this.recallSource = recallSource;
        }

        public Object getRecall_source() {
            return recall_source;
        }

        public void setRecall_source(Object recall_source) {
            this.recall_source = recall_source;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<PlayInfoBean> getPlayInfo() {
            return playInfo;
        }

        public void setPlayInfo(List<PlayInfoBean> playInfo) {
            this.playInfo = playInfo;
        }

        public List<?> getSubtitles() {
            return subtitles;
        }

        public void setSubtitles(List<?> subtitles) {
            this.subtitles = subtitles;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
