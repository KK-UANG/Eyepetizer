package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.WebViewModule;
import com.example.eyepetizer.mvp.contract.WebViewContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.eyepetizer.mvp.ui.activity.WebViewActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/07/2020 20:53
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = WebViewModule.class, dependencies = AppComponent.class)
public interface WebViewComponent {
    void inject(WebViewActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        WebViewComponent.Builder view(WebViewContract.View view);

        WebViewComponent.Builder appComponent(AppComponent appComponent);

        WebViewComponent build();
    }
}