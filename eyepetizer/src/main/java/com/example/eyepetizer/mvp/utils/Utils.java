package com.example.eyepetizer.mvp.utils;

public class Utils {

    public static String format(int duration) {
        String second = "";
        String minute = "";
        String time = "";
        //获取到时间
        int mm = duration / 60;//分
        int ss = duration % 60;//秒
        if (ss < 10) {
            second = "0" + String.valueOf(ss);
        } else {
            second = String.valueOf(ss);
        }
        if (mm < 10) {
            minute = "0" + String.valueOf(mm);
        } else {
            minute = String.valueOf(mm);//分钟
        }
        time = minute + ":" + second;

        return time;
    }



}
