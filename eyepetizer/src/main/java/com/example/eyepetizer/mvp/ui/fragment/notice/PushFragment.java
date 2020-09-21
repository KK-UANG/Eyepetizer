package com.example.eyepetizer.mvp.ui.fragment.notice;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.eyepetizer.app.base.MySupportFragment;
import com.example.eyepetizer.mvp.api.Api;
import com.example.eyepetizer.mvp.api.entity.PushBean;
import com.example.eyepetizer.mvp.api.service.ApiService;
import com.example.eyepetizer.mvp.ui.adapter.AttentionAdapter;
import com.example.eyepetizer.mvp.ui.adapter.PushAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerPushComponent;
import com.example.eyepetizer.mvp.contract.PushContract;
import com.example.eyepetizer.mvp.presenter.PushPresenter;

import com.example.eyepetizer.R;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


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
public class PushFragment extends MySupportFragment<PushPresenter> implements PushContract.View {


    @BindView(R.id.sw)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    private PushAdapter mAdapter;
    private String mNextPageUrl;

    public static PushFragment newInstance() {
        PushFragment fragment = new PushFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerPushComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_push, container, false);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.getPushData(ApiService.PUSH_URL, true);
        }
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new PushAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.getPushData(ApiService.PUSH_URL, true);
            }
        });

        mAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> {
            if (mPresenter != null && mNextPageUrl != null) {
                mPresenter.getPushData(mNextPageUrl, false);
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
    public void setPushData(PushBean data, boolean isInit) {
        String pageUrl = data.getNextPageUrl();
        if (isInit) {
            mAdapter.setNewData(data.getMessageList());
        } else {
            if (!TextUtils.isEmpty(pageUrl)) {
                mAdapter.addData(data.getMessageList());
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
