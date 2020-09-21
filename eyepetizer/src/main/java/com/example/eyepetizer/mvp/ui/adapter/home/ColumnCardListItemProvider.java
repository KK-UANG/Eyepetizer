package com.example.eyepetizer.mvp.ui.adapter.home;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;

public class ColumnCardListItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.COLUMN_CARD_LIST;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_column_card;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        holder.setText(R.id.tv_title, data.getData().getHeader().getTitle())
                .setText(R.id.tv_title_2, data.getData().getHeader().getRightText());
        RecyclerView recyclerView = holder.getView(R.id.rv_column_card);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ColumnCardListAdapter adapter = new ColumnCardListAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setNewData(data.getData().getItemList());
    }
}
