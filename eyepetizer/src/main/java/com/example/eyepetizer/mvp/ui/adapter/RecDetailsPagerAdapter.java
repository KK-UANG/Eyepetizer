package com.example.eyepetizer.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.adapter.home.HorizontalScrollCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.rec.CommunityColumnsCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.rec.ItemCollectionItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.recdetails.UgcPictureItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.recdetails.VideoItemProvider;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecDetailsPagerAdapter extends BaseProviderMultiAdapter<ItemListBean> implements LoadMoreModule {

    public RecDetailsPagerAdapter() {
        super();
        addItemProvider(new EmptyPagerItemProvider());
        addItemProvider(new VideoItemProvider());
        addItemProvider(new UgcPictureItemProvider());
        addChildClickViewIds(R.id.ivPullDown);
    }

    @Override
    protected int getItemType(@NotNull List<? extends ItemListBean> list, int i) {
        ItemListBean.DataBean dataBean = list.get(i).getData();
        String type = dataBean.getDataType();
        if (type.equals("FollowCard")) {
            String type1 = dataBean.getContent().getType();
            if (type1.equals("ugcPicture")) {
                return ItemViewType.UGC_PICTURE;
            } else if (type1.equals("video")) {
                return ItemViewType.VIDEO;
            }
        }
        return 0;
    }
}
