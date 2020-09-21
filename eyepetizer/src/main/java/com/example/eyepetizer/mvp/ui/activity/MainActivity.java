package com.example.eyepetizer.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eyepetizer.app.base.MySupportActivity;
import com.example.eyepetizer.mvp.ui.fragment.CommunityFragment;
import com.example.eyepetizer.mvp.ui.fragment.HomeFragment;
import com.example.eyepetizer.mvp.ui.fragment.MineFragment;
import com.example.eyepetizer.mvp.ui.fragment.NoticeFragment;
import com.gyf.immersionbar.ImmersionBar;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerMainComponent;
import com.example.eyepetizer.mvp.contract.MainContract;
import com.example.eyepetizer.mvp.presenter.MainPresenter;

import com.example.eyepetizer.R;


import butterknife.BindView;
import me.yokeyword.fragmentation.SupportFragment;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/31/2020 16:57
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class MainActivity extends MySupportActivity<MainPresenter> implements MainContract.View {


    @BindView(R.id.nav_main)
    BottomNavigationViewEx mNavigationView;

    private SupportFragment[] mFragments = new SupportFragment[4];
    private double firstTime = 0;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerMainComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initBar();
        // 初始化fragment
        initFragment();
        // 底部切换
        initBottomNav();
    }

    private void initBar() {
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    private void initBottomNav() {
        mNavigationView.enableAnimation(false);
        mNavigationView.enableShiftingMode(false);
        mNavigationView.enableItemShiftingMode(false);
        mNavigationView.setCurrentItem(0);
        mNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    showHideFragment(mFragments[0]);
                    break;
                case R.id.nav_community:
                    showHideFragment(mFragments[1]);
                    break;
                case R.id.nav_notice:
                    showHideFragment(mFragments[2]);
                    break;
                case R.id.nav_mine:
                    showHideFragment(mFragments[3]);
                    break;
                default:
                    break;
            }
            return true;
        });
    }

    private void initFragment() {
        SupportFragment firstFragment = findFragment(HomeFragment.class);
        if (firstFragment == null) {
            mFragments[0] = HomeFragment.newInstance();
            mFragments[1] = CommunityFragment.newInstance();
            mFragments[2] = NoticeFragment.newInstance();
            mFragments[3] = MineFragment.newInstance();
            loadMultipleRootFragment(R.id.fl_main, 0,
                    mFragments[0],
                    mFragments[1],
                    mFragments[2],
                    mFragments[3]
            );
        } else {
            mFragments[0] = firstFragment;
            mFragments[1] = findFragment(CommunityFragment.class);
            mFragments[2] = findFragment(NoticeFragment.class);
            mFragments[3] = findFragment(MineFragment.class);
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    public void onBackPressedSupport() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ArmsUtils.makeText(this, "再按一次退出程序");
            firstTime = secondTime;
        } else {
            ArmsUtils.exitApp();
        }
    }
}
