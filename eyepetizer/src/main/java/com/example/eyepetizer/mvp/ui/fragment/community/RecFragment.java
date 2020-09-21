package com.example.eyepetizer.mvp.ui.fragment.community;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.example.eyepetizer.app.base.MySupportFragment;
import com.example.eyepetizer.mvp.api.Api;
import com.example.eyepetizer.mvp.api.entity.DataBean;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.api.service.ApiService;
import com.example.eyepetizer.mvp.ui.activity.RecDetailsActivity;
import com.example.eyepetizer.mvp.ui.adapter.RecMultiAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerRecComponent;
import com.example.eyepetizer.mvp.contract.RecContract;
import com.example.eyepetizer.mvp.presenter.RecPresenter;

import com.example.eyepetizer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * 社区推荐
 */
public class RecFragment extends MySupportFragment<RecPresenter> implements RecContract.View {

    @BindView(R.id.sw)
    SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.rv)
    RecyclerView mRecyclerView;
    public RecMultiAdapter mAdapter;
    private String mNextPageUrl;

    public static RecFragment newInstance() {
        RecFragment fragment = new RecFragment();
        return fragment;
    }

    @Override
    public void setupFragmentComponent(@NonNull AppComponent appComponent) {
        DaggerRecComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rec, container, false);
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        if (mPresenter != null) {
            mPresenter.getRecData(ApiService.REC_URl, true);
        }
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecMultiAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            if (mPresenter != null) {
                mPresenter.getRecData(ApiService.REC_URl, true);
            }
        });

        mAdapter.getLoadMoreModule().setOnLoadMoreListener(() -> {
            if (mPresenter != null && mNextPageUrl != null) {
                mPresenter.getRecData(mNextPageUrl, false);
            }
        });


        mAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (position != 0 && position != 1) {
                List<ItemListBean> listBeans = mAdapter.getData();
                Intent intent = new Intent(_mActivity, RecDetailsActivity.class);
                intent.putExtra(RecDetailsActivity.Data, (Serializable) listBeans);
                intent.putExtra(RecDetailsActivity.POSITION, position);
                ArmsUtils.startActivity(intent);
                _mActivity.overridePendingTransition(R.anim.anl_push_bottom_in, R.anim.anl_push_up_out);
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
    public void setRecData(DataBean data, boolean isInit) {
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
