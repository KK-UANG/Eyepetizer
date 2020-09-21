package com.example.eyepetizer.mvp.ui.adapter.home;

import android.text.TextUtils;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;

public class TextCardItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.TEXT_CARD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_title;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        holder.setText(R.id.tv_title, data.getData().getText())
                .setText(R.id.tv_title_2, data.getData().getRightText())
                .setVisible(R.id.iv_into, !TextUtils.isEmpty(data.getData().getRightText()));
    }
}
