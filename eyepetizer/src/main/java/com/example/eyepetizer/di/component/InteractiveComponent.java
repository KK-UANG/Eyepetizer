package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.InteractiveModule;
import com.example.eyepetizer.mvp.contract.InteractiveContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.notice.InteractiveFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/07/2020 15:31
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = InteractiveModule.class, dependencies = AppComponent.class)
public interface InteractiveComponent {
    void inject(InteractiveFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        InteractiveComponent.Builder view(InteractiveContract.View view);

        InteractiveComponent.Builder appComponent(AppComponent appComponent);

        InteractiveComponent build();
    }
}