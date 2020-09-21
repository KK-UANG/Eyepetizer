package com.example.eyepetizer.mvp.ui.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InformationCardAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public InformationCardAdapter() {
        super(R.layout.item_information_card);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, @Nullable String data) {
        holder.setText(R.id.tv_title, data);
    }
}
