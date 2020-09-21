package com.example.eyepetizer.mvp.ui.adapter.home;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;

public class BriefCardItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.BRIEF_CARD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_brief_card;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        holder.setText(R.id.tv_brief_title, data.getData().getTitle())
                .setText(R.id.tv_brief_description, data.getData().getDescription());
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context, ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageRadius(10)
                        .imageView(holder.getView(R.id.iv_brief))
                        .url(data.getData().getIcon())
                        .build());
    }
}
