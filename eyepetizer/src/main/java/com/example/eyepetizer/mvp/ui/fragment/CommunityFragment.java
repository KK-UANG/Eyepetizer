package com.example.eyepetizer.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eyepetizer.app.base.MySupportFragment;
import com.example.eyepetizer.mvp.ui.adapter.CommunityPagerAdapter;
import com.example.eyepetizer.mvp.ui.adapter.HomePagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerCommunityComponent;
import com.example.eyepetizer.mvp.contract.CommunityContract;
import com.example.eyepetizer.mvp.presenter.CommunityPresenter;

import com.example.eyepetizer.R;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * 社区
 */
public class CommunityFragment extends MySupportFragment<CommunityPresenter> implements CommunityContract.View {

    @BindView(R.id.tl_community)
    TabLayout mTableLayout;
    @BindView(R.id.vp_community)
    ViewPager mViewPager;
    private CommunityPagerAdapter mPagerAdapter;

    public static CommunityFragment newInstance() {
        CommunityFragment fragment = new CommunityFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerCommunityComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_community, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mTableLayout.setupWithViewPager(mViewPager);
        mPagerAdapter = new CommunityPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
    }

    @Override
    public void setData(@Nullable Object data) {

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

    }
}
