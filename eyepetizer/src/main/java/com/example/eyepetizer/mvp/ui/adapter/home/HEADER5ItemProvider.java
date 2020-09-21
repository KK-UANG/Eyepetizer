package com.example.eyepetizer.mvp.ui.adapter.home;

import android.text.TextUtils;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HEADER5ItemProvider extends BaseItemProvider<ItemListBean> {
    @Override
    public int getItemViewType() {
        return ItemViewType.HEADER_5;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_header5;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        holder.setText(R.id.tv_title, data.getData().getText())
                .setVisible(R.id.btn_attention, !TextUtils.isEmpty(data.getData().getActionUrl()))
                .setVisible(R.id.ic_into_gray, !TextUtils.isEmpty(data.getData().getActionUrl()));
    }
}
