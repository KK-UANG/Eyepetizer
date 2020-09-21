package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.NoticeModule;
import com.example.eyepetizer.mvp.contract.NoticeContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.NoticeFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/31/2020 21:13
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = NoticeModule.class, dependencies = AppComponent.class)
public interface NoticeComponent {
    void inject(NoticeFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        NoticeComponent.Builder view(NoticeContract.View view);

        NoticeComponent.Builder appComponent(AppComponent appComponent);

        NoticeComponent build();
    }
}