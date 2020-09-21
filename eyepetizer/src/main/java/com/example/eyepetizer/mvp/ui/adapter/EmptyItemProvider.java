package com.example.eyepetizer.mvp.ui.adapter;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EmptyItemProvider extends BaseItemProvider<ItemListBean> {
    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_empty;
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder, @Nullable ItemListBean itemListBean) {

    }
}
