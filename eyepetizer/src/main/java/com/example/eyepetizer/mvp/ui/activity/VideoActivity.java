package com.example.eyepetizer.mvp.ui.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.eyepetizer.app.base.MySupportActivity;
import com.example.eyepetizer.mvp.api.entity.VideoBean;
import com.gyf.immersionbar.ImmersionBar;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerVideoComponent;
import com.example.eyepetizer.mvp.contract.VideoContract;
import com.example.eyepetizer.mvp.presenter.VideoPresenter;

import com.example.eyepetizer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;


import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * ================================================
 */
public class VideoActivity extends MySupportActivity<VideoPresenter> implements VideoContract.View {


    @BindView(R.id.player_video)
    StandardGSYVideoPlayer mVideoPlayer;
    public static final String PLAY_URL = "playUrl";
    private OrientationUtils mOrientationUtils;
    private GSYVideoOptionBuilder mGsyVideoOptionBuilder;
    private boolean isPlay;
    private boolean isPause;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerVideoComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_video; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initBar();
        initId();
    }

    private void initId() {
        Intent intent = getIntent();
        if (intent != null) {
            String url = intent.getStringExtra(PLAY_URL);
            initPlayer(url);
        }
    }

    private void initBar() {
        ImmersionBar.with(this)
                .statusBarColor(R.color.black)
                .statusBarDarkFont(false, 0.2f)
                .init();
    }


    @Override
    public void setVideoData(VideoBean data) {
//        initPlayer(data);
    }

    private void initPlayer(String palUrl) {
        mOrientationUtils = new OrientationUtils(this, mVideoPlayer);
        mGsyVideoOptionBuilder = new GSYVideoOptionBuilder();
        mGsyVideoOptionBuilder.setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(true)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setUrl(palUrl)
                .setCacheWithPlay(false)
                .setStartAfterPrepared(true)
                .setVideoAllCallBack(new GSYSampleCallBack() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        //开始播放了才能旋转和全屏
                        mOrientationUtils.setEnable(true);
                        isPlay = true;
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        //当前非全屏player
                        if (mOrientationUtils != null) {
                            mOrientationUtils.backToProtVideo();
                        }
                    }
                }).setLockClickListener((view, lock) -> {
                    if (mOrientationUtils != null) {
                        //配合下方的onConfigurationChanged
                        mOrientationUtils.setEnable(!lock);
                    }
                }).build(mVideoPlayer);

        mVideoPlayer.startPlayLogic();
        mVideoPlayer.getFullscreenButton().setOnClickListener(v -> {
            //直接横屏
            mOrientationUtils.resolveByClick();
            //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
            mVideoPlayer.startWindowFullscreen(VideoActivity.this, true, true);
        });

        mVideoPlayer.getBackButton().setOnClickListener(view -> {
            if (GSYVideoManager.backFromWindowFull(VideoActivity.this)) {
                return;
            } else {
                finish();
            }
        });
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
        if (mOrientationUtils != null) {
            mOrientationUtils.backToProtVideo();
        }
        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressedSupport();
    }


    @Override
    protected void onPause() {
        mVideoPlayer.getCurrentPlayer().onVideoPause();
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        mVideoPlayer.getCurrentPlayer().onVideoResume(false);
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        if (isPlay) {
            mVideoPlayer.getCurrentPlayer().release();
        }
        if (mOrientationUtils != null)
            mOrientationUtils.releaseListener();
        super.onDestroy();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            mVideoPlayer.onConfigurationChanged(this, newConfig, mOrientationUtils, true, true);
        }
    }
}
