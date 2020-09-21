package com.example.eyepetizer.mvp.ui.adapter.home;

import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.activity.WebViewActivity;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;

public class BannerItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.BANNER;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_banner;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context, ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageRadius(10)
                        .imageView(holder.getView(R.id.iv_brief))
                        .url(data.getData().getImage())
                        .build());
    }

    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, ItemListBean data, int position) {
        super.onClick(helper, view, data, position);
        String actionUrl = data.getData().getActionUrl();
        if (actionUrl.contains("webview")) {
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra(WebViewActivity.ACTION_URL, actionUrl);
            ArmsUtils.startActivity(intent);
        }
    }
}
