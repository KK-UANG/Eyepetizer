package com.example.eyepetizer.mvp.ui.adapter.home;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;

public class TopCategoriesAdapter extends BaseQuickAdapter<ItemListBean, BaseViewHolder> {

    public TopCategoriesAdapter() {
        super(R.layout.item_sort);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        holder.setText(R.id.tv_sort, data.getData().getTitle());
        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageRadius(10)
                        .imageView(holder.getView(R.id.iv_sort))
                        .url(data.getData().getImage())
                        .build());
    }
}
