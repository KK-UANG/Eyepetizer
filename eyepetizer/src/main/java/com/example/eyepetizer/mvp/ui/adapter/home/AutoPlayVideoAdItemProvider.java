package com.example.eyepetizer.mvp.ui.adapter.home;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;

public class AutoPlayVideoAdItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.AUTO_PLAY_VIDEO_AD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_ad;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, ItemListBean data) {

    }
}
