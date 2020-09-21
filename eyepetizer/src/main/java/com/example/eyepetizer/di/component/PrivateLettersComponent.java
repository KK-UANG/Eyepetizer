package com.example.eyepetizer.di.component;

import dagger.BindsInstance;
import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import com.example.eyepetizer.di.module.PrivateLettersModule;
import com.example.eyepetizer.mvp.contract.PrivateLettersContract;

import com.jess.arms.di.scope.FragmentScope;
import com.example.eyepetizer.mvp.ui.fragment.notice.PrivateLettersFragment;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/07/2020 15:33
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = PrivateLettersModule.class, dependencies = AppComponent.class)
public interface PrivateLettersComponent {
    void inject(PrivateLettersFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        PrivateLettersComponent.Builder view(PrivateLettersContract.View view);

        PrivateLettersComponent.Builder appComponent(AppComponent appComponent);

        PrivateLettersComponent build();
    }
}