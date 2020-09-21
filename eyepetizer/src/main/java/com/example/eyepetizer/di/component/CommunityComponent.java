package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.CommunityModule;
import com.example.eyepetizer.mvp.contract.CommunityContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.CommunityFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/31/2020 21:12
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = CommunityModule.class, dependencies = AppComponent.class)
public interface CommunityComponent {
    void inject(CommunityFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CommunityComponent.Builder view(CommunityContract.View view);

        CommunityComponent.Builder appComponent(AppComponent appComponent);

        CommunityComponent build();
    }
}