package com.example.eyepetizer.mvp.ui.adapter.rec;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemCollectionItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.ITEM_COLLECTION;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder, int viewType) {
        super.onViewHolderCreated(viewHolder, viewType);
        StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams();
        layoutParams.setFullSpan(true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_collection;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {

        RecyclerView view = holder.getView(R.id.rv_item_collection);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        view.setLayoutManager(layoutManager);
        ItemCollectionAdapter adapter = new ItemCollectionAdapter();
        view.setAdapter(adapter);
        adapter.setNewData(data.getData().getItemList());
    }
}
