package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.DailyModule;
import com.example.eyepetizer.mvp.contract.DailyContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.home.DailyFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/01/2020 16:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = DailyModule.class, dependencies = AppComponent.class)
public interface DailyComponent {
    void inject(DailyFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        DailyComponent.Builder view(DailyContract.View view);

        DailyComponent.Builder appComponent(AppComponent appComponent);

        DailyComponent build();
    }
}