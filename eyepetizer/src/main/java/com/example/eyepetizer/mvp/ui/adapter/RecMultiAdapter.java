package com.example.eyepetizer.mvp.ui.adapter;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.adapter.home.HorizontalScrollCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.rec.CommunityColumnsCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.rec.ItemCollectionItemProvider;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecMultiAdapter extends BaseProviderMultiAdapter<ItemListBean> implements LoadMoreModule {

    private int mPosition;

    public RecMultiAdapter() {
        super();
        addItemProvider(new EmptyItemProvider());
        addItemProvider(new HorizontalScrollCardItemProvider());
        addItemProvider(new ItemCollectionItemProvider());
        addItemProvider(new CommunityColumnsCardItemProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends ItemListBean> list, int i) {
        String type = list.get(i).getData().getDataType();
        if (type.equals("ItemCollection")) {
            return ItemViewType.ITEM_COLLECTION;
        } else if (type.equals("HorizontalScrollCard")) {
            this.mPosition = i;
            return ItemViewType.HORIZONTAL_SCROLL_CARD;
        } else if (type.equals("FollowCard")) {
            return ItemViewType.COMMUNITY_COLUMNS_CARD;
        }
        return 0;
    }

    @Override
    public void onViewAttachedToWindow(@NotNull BaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        int position = holder.getLayoutPosition();
        if (position == mPosition) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
            p.setFullSpan(true);
        }
    }
}
