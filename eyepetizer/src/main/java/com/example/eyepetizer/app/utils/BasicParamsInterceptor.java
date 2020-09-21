package com.example.eyepetizer.app.utils;

import android.os.Build;
import android.util.Log;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BasicParamsInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        HttpUrl url = request.url();
        HttpUrl build = url.newBuilder()
                .addQueryParameter("udid", "a08dd4b77f4a4e7da1e7768bf20643ceb3c5dd8d")
                .addQueryParameter("size", "1440X3120")
                .addQueryParameter("deviceModel", "GM1910")
                .addQueryParameter("first_channel", "eyepetizer_web")
                .addQueryParameter("last_channel", "eyepetizer_web")
                .addQueryParameter("system_version_code", "29")
                .addQueryParameter("vc", "591")
                .addQueryParameter("vn", "6.2.1")
                .build();
        Request build1 = request.newBuilder().url(build).method(request.method(), request.body()).build();
        return chain.proceed(build1);


    }
}
