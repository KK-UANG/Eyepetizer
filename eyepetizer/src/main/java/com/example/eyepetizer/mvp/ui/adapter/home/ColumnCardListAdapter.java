package com.example.eyepetizer.mvp.ui.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;

public class ColumnCardListAdapter extends BaseQuickAdapter<ItemListBean, BaseViewHolder> {

    public ColumnCardListAdapter() {
        super(R.layout.item_column_card);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        holder.setText(R.id.tv_column_card, data.getData().getTitle());
        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageRadius(10)
                        .imageView(holder.getView(R.id.iv_column_card))
                        .url(data.getData().getImage())
                        .build());
    }
}

