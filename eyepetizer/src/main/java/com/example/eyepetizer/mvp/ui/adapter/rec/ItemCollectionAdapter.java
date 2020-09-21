package com.example.eyepetizer.mvp.ui.adapter.rec;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemCollectionAdapter extends BaseQuickAdapter<ItemListBean, BaseViewHolder> {

    public ItemCollectionAdapter() {
        super(R.layout.item_collection);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        holder.setText(R.id.tv_title, data.getData().getTitle())
                .setText(R.id.tv_sub_title, data.getData().getSubTitle());

        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageRadius(10)
                        .imageView(holder.getView(R.id.iv_bg_picture))
                        .url(data.getData().getBgPicture())
                        .build());
    }
}
