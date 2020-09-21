package com.example.eyepetizer.mvp.ui.activity;

import android.content.Intent;
import android.media.AsyncPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.eyepetizer.app.base.MySupportActivity;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.adapter.RecDetailsPagerAdapter;
import com.example.eyepetizer.mvp.ui.player.AutoPlayPageChangeListener;
import com.example.eyepetizer.mvp.ui.player.PagerScrolling;
import com.gyf.immersionbar.ImmersionBar;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerRecDetailsComponent;
import com.example.eyepetizer.mvp.contract.RecDetailsContract;
import com.example.eyepetizer.mvp.presenter.RecDetailsPresenter;

import com.example.eyepetizer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer;


import java.io.Serializable;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/10/2020 13:53
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class RecDetailsActivity extends MySupportActivity<RecDetailsPresenter> implements RecDetailsContract.View {


    @BindView(R.id.vp2_rec_details)
    ViewPager2 mViewPager2;

    public static final String POSITION = "position";
    public static String Data = "RecDetailsActivity";
    private int mPosition;
    private RecDetailsPagerAdapter mPagerAdapter;
    private List<ItemListBean> mList;


    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerRecDetailsComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_rec_details; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initBar();

        Intent intent = getIntent();
        if (intent != null) {
            mList = (List<ItemListBean>) intent.getSerializableExtra(Data);
            mPosition = intent.getIntExtra(POSITION, 1);
        }
        mPagerAdapter = new RecDetailsPagerAdapter();

        mPagerAdapter.setNewData(mList);
        mPagerAdapter.remove(1);
        mPagerAdapter.remove(0);
        mViewPager2.setAdapter(mPagerAdapter);
        mViewPager2.registerOnPageChangeCallback(new AutoPlayPageChangeListener(mViewPager2, mPosition - 2, R.id.videoPlayer));
        mViewPager2.setCurrentItem(mPosition - 2, false);


        mPagerAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            if (view.getId() == R.id.ivPullDown) {
                finish();
                overridePendingTransition(0, R.anim.anl_push_bottom_out);
            }
        });
    }

    private void initBar() {
        ImmersionBar.with(this)
                .statusBarColor(R.color.black)
                .statusBarDarkFont(false, 0.2f)
                .init();
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
    protected void onResume() {
        GSYVideoManager.onResume(true);
        super.onResume();
    }

    @Override
    protected void onPause() {
        GSYVideoManager.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        GSYVideoManager.releaseAllVideos();
        super.onDestroy();
    }
}
