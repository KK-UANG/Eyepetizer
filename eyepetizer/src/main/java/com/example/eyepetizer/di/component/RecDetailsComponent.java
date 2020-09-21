package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.RecDetailsModule;
import com.example.eyepetizer.mvp.contract.RecDetailsContract;

import com.jess.arms.di.scope.ActivityScope;
import com.example.eyepetizer.mvp.ui.activity.RecDetailsActivity;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/10/2020 13:53
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(modules = RecDetailsModule.class, dependencies = AppComponent.class)
public interface RecDetailsComponent {
    void inject(RecDetailsActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        RecDetailsComponent.Builder view(RecDetailsContract.View view);

        RecDetailsComponent.Builder appComponent(AppComponent appComponent);

        RecDetailsComponent build();
    }
}