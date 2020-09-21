package com.example.eyepetizer.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blankj.utilcode.util.EncodeUtils;
import com.example.eyepetizer.app.base.MySupportActivity;
import com.example.eyepetizer.mvp.api.Api;
import com.gyf.immersionbar.ImmersionBar;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.example.eyepetizer.di.component.DaggerWebViewComponent;
import com.example.eyepetizer.mvp.contract.WebViewContract;
import com.example.eyepetizer.mvp.presenter.WebViewPresenter;

import com.example.eyepetizer.R;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.LollipopFixedWebView;


import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 09/07/2020 20:53
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class WebViewActivity extends MySupportActivity<WebViewPresenter> implements WebViewContract.View {

    @BindView(R.id.web_view)
    LinearLayout mWeb;
    @BindView(R.id.tv_web)
    TextView mtvTitle;

    @OnClick(R.id.btn_calendar)
    public void back() {
        finish();
    }

    private AgentWeb mAgentWeb;

    public static final String ACTION_URL = "actionUrl";
    private String mUrl;
    private String mTitle;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerWebViewComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_web_view; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initBar();
        initUrl();
        initWeb();
    }

    private void initUrl() {
        Intent intent = getIntent();
        if (intent != null) {
            String extra = intent.getStringExtra(ACTION_URL);
            if (!extra.isEmpty()) {
                String urlDecode = EncodeUtils.urlDecode(extra);
                mUrl = urlDecode.substring(urlDecode.lastIndexOf("url=") + 4);
                mTitle = urlDecode.substring(urlDecode.indexOf("title=") + 6, urlDecode.indexOf("&url="));
            }
        }
        mtvTitle.setText(mTitle.isEmpty() ? "" : mTitle);
    }

    private void initWeb() {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(mWeb, new LinearLayout.LayoutParams(-1, -1))
                .useDefaultIndicator()
                .setWebView(new LollipopFixedWebView(this))
                .createAgentWeb()
                .ready()
                .go(mUrl);
    }

    private void initBar() {
        ImmersionBar.with(this)
                .statusBarColor(R.color.colorPrimary)
                .statusBarDarkFont(true, 0.2f)
                .init();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (mAgentWeb.handleKeyEvent(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();

    }

    @Override
    protected void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
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
}
