package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.AttentionModule;
import com.example.eyepetizer.mvp.contract.AttentionContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.community.AttentionFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/05/2020 16:04
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = AttentionModule.class, dependencies = AppComponent.class)
public interface AttentionComponent {
    void inject(AttentionFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AttentionComponent.Builder view(AttentionContract.View view);

        AttentionComponent.Builder appComponent(AppComponent appComponent);

        AttentionComponent build();
    }
}