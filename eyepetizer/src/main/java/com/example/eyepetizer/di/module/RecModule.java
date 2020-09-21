package com.example.eyepetizer.di.module;

import com.example.eyepetizer.mvp.contract.RecContract;

import dagger.Binds;
import dagger.Module;

import com.example.eyepetizer.mvp.model.RecModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/05/2020 16:00
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class RecModule {

    @Binds
    abstract RecContract.Model bindRecommendationModel(RecModel model);
}