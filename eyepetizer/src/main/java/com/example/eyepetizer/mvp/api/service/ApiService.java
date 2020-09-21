package com.example.eyepetizer.mvp.api.service;

import com.example.eyepetizer.mvp.api.entity.DataBean;
import com.example.eyepetizer.mvp.api.entity.PushBean;
import com.example.eyepetizer.mvp.api.entity.VideoBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiService {

    String FIND_URL = "v7/index/tab/discovery";

    @GET(FIND_URL)
    Observable<DataBean> getFindData();

    String RECOMMEND_URL = "v5/index/tab/allRec";

    @GET
    Observable<DataBean> getRecommendData(@Url String url);

    String DAILY_URl = "v5/index/tab/feed";

    @GET
    Observable<DataBean> getDailyData(@Url String url);

    String REC_URl = "v7/community/tab/rec";

    @GET
    Observable<DataBean> getRecData(@Url String url);

    String FOLLOW_URL = "v6/community/tab/follow";

    @GET
    Observable<DataBean> getAttentionData(@Url String url);

    String PUSH_URL = "v3/messages";

    @GET
    Observable<PushBean> getPushData(@Url String url);

    @GET("v2/video/{id}")
    Observable<VideoBean> getVideoData(@Path("id") Long id);
}
