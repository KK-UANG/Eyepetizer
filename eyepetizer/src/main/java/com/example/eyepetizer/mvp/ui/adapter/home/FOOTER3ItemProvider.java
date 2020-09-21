package com.example.eyepetizer.mvp.ui.adapter.home;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FOOTER3ItemProvider extends BaseItemProvider<ItemListBean> {
    @Override
    public int getItemViewType() {
        return ItemViewType.FOOTER_3;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_footer3;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        holder.setText(R.id.tv_footer3, data.getData().getText());
    }
}
