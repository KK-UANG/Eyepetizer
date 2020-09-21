package com.example.eyepetizer.mvp.ui.fragment.community;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eyepetizer.app.base.MySupportFragment;
import com.example.eyepetizer.mvp.api.Api;
import com.example.eyepetizer.mvp.api.entity.DataBean;
import com.example.eyepetizer.mvp.api.service.ApiService;
import com.example.eyepetizer.mvp.ui.adapter.AttentionAdapter;
import com.example.eyepetizer.mvp.ui.player.ListScrolling;
import com.example.eyepetizer.mvp.ui.player.ScrollCalculatorHelper;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerAttentionComponent;
import com.example.eyepetizer.mvp.contract.AttentionContract;
import com.example.eyepetizer.mvp.presenter.AttentionPresenter;

import com.example.eyepetizer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.CommonUtil;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/05/2020 16:04
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class AttentionFragment extends MySupportFragment<AttentionPresenter> implements AttentionContract.View {

    @BindView(R.id.sw)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    private AttentionAdapter mAdapter;
    private String mNextPageUrl;
    private LinearLayoutManager mLayoutManager;
    private ListScrolling mListScrolling;

    public static AttentionFragment newInstance() {
        AttentionFragment fragment = new AttentionFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerAttentionComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_attention, container, false);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.getAttentionData(ApiService.FOLLOW_URL, true);
        }
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initAdapter();
        initListener();
        initPlay();
    }

    private void initPlay() {

        // 控制自动播放帮助类
        mListScrolling = new ListScrolling();

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE://停止滚动
                        /**在这里执行，视频的自动播放与停止*/
                        mListScrolling.autoPlayVideo(recyclerView);
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING://惯性滑动
                        GSYVideoManager.releaseAllVideos();
                        break;
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                firstVisibleItem = mLayoutManager.findFirstVisibleItemPosition();
//                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
//                if (!mFull) {
//                    mScrollCalculatorHelper.onScroll(recyclerView,
//                            firstVisibleItem,
//                            lastVisibleItem,
//                            lastVisibleItem - firstVisibleItem);
//                }
                mListScrolling.onScrolled(recyclerView);
            }
        });
    }

    private void initListener() {
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.getAttentionData(ApiService.FOLLOW_URL, true);
                GSYVideoManager.releaseAllVideos();
            }
        });

        mAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> {
            if (mPresenter != null && mNextPageUrl != null) {
                mPresenter.getAttentionData(mNextPageUrl, false);
            }
        });
    }

    private void initAdapter() {
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AttentionAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void setData(@Nullable Object data) {

    }

    @Override
    public void showLoading() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        if (mSwipeRefreshLayout != null) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
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

    @Override
    public void setAttentionData(DataBean data, boolean isInit) {
        String pageUrl = data.getNextPageUrl();
        if (isInit) {
            mAdapter.setNewData(data.getItemList());
        } else {
            if (!TextUtils.isEmpty(pageUrl)) {
                mAdapter.addData(data.getItemList());
                mAdapter.getLoadMoreModule().loadMoreComplete();
            } else {
                mAdapter.getLoadMoreModule().loadMoreEnd();
            }
        }
        if (!TextUtils.isEmpty(pageUrl)) {
            mNextPageUrl = pageUrl.replaceAll(Api.APP_DOMAIN, "");
        }
    }

    @Override
    public void onSupportVisible() {
        super.onSupportVisible();
        GSYVideoManager.onResume(true);
    }


    @Override
    public void onSupportInvisible() {
        super.onSupportInvisible();
        GSYVideoManager.onPause();
    }



    @Override
    public void onDestroy() {
        GSYVideoManager.releaseAllVideos();
        super.onDestroy();
    }
}
