package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.FindModule;
import com.example.eyepetizer.mvp.contract.FindContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.home.FindFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/01/2020 16:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = FindModule.class, dependencies = AppComponent.class)
public interface FindComponent {
    void inject(FindFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        FindComponent.Builder view(FindContract.View view);

        FindComponent.Builder appComponent(AppComponent appComponent);

        FindComponent build();
    }
}