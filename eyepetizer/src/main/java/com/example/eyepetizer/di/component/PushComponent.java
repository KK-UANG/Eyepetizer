package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.PushModule;
import com.example.eyepetizer.mvp.contract.PushContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.notice.PushFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/07/2020 15:26
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = PushModule.class, dependencies = AppComponent.class)
public interface PushComponent {
    void inject(PushFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        PushComponent.Builder view(PushContract.View view);

        PushComponent.Builder appComponent(AppComponent appComponent);

        PushComponent build();
    }
}