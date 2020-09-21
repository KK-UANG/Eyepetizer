package com.example.eyepetizer.di.module;

import dagger.Binds;
import dagger.Module;

import com.example.eyepetizer.mvp.contract.RecommendContract;
import com.example.eyepetizer.mvp.model.RecommendModel;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/01/2020 16:12
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
public abstract class RecommendModule {

    @Binds
    abstract RecommendContract.Model bindRecommendModel(RecommendModel model);
}