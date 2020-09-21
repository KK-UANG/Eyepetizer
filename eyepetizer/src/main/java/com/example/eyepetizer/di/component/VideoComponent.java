package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.VideoModule;
import com.example.eyepetizer.mvp.contract.VideoContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.eyepetizer.mvp.ui.activity.VideoActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/09/2020 16:34
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = VideoModule.class, dependencies = AppComponent.class)
public interface VideoComponent {
    void inject(VideoActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        VideoComponent.Builder view(VideoContract.View view);

        VideoComponent.Builder appComponent(AppComponent appComponent);

        VideoComponent build();
    }
}