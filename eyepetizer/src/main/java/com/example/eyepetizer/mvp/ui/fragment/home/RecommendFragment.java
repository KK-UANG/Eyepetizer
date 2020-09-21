package com.example.eyepetizer.mvp.ui.fragment.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eyepetizer.app.base.MySupportFragment;
import com.example.eyepetizer.mvp.api.Api;
import com.example.eyepetizer.mvp.api.entity.DataBean;
import com.example.eyepetizer.mvp.api.service.ApiService;
import com.example.eyepetizer.mvp.ui.adapter.HomeMultiAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerRecommendComponent;
import com.example.eyepetizer.mvp.contract.RecommendContract;
import com.example.eyepetizer.mvp.presenter.RecommendPresenter;

import com.example.eyepetizer.R;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * 首页推荐
 */
public class RecommendFragment extends MySupportFragment<RecommendPresenter> implements RecommendContract.View {

    @BindView(R.id.sw)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    private HomeMultiAdapter mAdapter;
    private String mNextPageUrl;

    public static RecommendFragment newInstance() {
        RecommendFragment fragment = new RecommendFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerRecommendComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recommend, container, false);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.getRecommendData(ApiService.RECOMMEND_URL, true);
        }
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new HomeMultiAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.getRecommendData(ApiService.RECOMMEND_URL, true);
            }
        });

        mAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> {
            if (mPresenter != null && mNextPageUrl != null) {
                mPresenter.getRecommendData(mNextPageUrl, false);
            }
        });

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
    public void setRecommendData(DataBean data, boolean isInit) {
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
}
