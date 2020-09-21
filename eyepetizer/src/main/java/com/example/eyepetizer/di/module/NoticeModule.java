package com.example.eyepetizer.di.module;

import dagger.Binds;
import dagger.Module;

import com.example.eyepetizer.mvp.contract.NoticeContract;
import com.example.eyepetizer.mvp.model.NoticeModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/31/2020 21:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class NoticeModule {

    @Binds
    abstract NoticeContract.Model bindNoticeModel(NoticeModel model);
}