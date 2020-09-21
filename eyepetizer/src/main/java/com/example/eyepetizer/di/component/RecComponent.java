package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.RecModule;
import com.example.eyepetizer.mvp.contract.RecContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.community.RecFragment;


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
@FragmentScope
@Component(modules = RecModule.class, dependencies = AppComponent.class)
public interface RecComponent {
    void inject(RecFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        RecComponent.Builder view(RecContract.View view);

        RecComponent.Builder appComponent(AppComponent appComponent);

        RecComponent build();
    }
}