package com.example.eyepetizer.mvp.ui.adapter.home;

import android.content.Intent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.activity.WebViewActivity;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InformationCardItemProvider extends BaseItemProvider<ItemListBean> {
    @Override
    public int getItemViewType() {
        return ItemViewType.INFORMATION_CARD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_information_card;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        RecyclerView recyclerView = holder.getView(R.id.rv_information);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        InformationCardAdapter adapter = new InformationCardAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNewData(data.getData().getTitleList());
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context, ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageView(holder.getView(R.id.iv_cover))
                        .url(data.getData().getBackgroundImage())
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
