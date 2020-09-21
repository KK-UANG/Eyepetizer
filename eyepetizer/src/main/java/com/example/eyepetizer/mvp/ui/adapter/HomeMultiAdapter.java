package com.example.eyepetizer.mvp.ui.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.adapter.home.FOOTER2ItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.FOOTER3ItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.FollowCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.HEADER5ItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.InformationCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.AutoPlayVideoAdItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.BannerItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.BriefCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.ColumnCardListItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.HorizontalScrollCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.TextCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.TopCategoriesItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.UgcSelectedCardItemProvider;
import com.example.eyepetizer.mvp.ui.adapter.home.VideoSmallCardItemProvider;
import com.example.eyepetizer.mvp.utils.ItemViewType;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomeMultiAdapter extends BaseProviderMultiAdapter<ItemListBean> implements LoadMoreModule {

    public HomeMultiAdapter() {
        super();
        addItemProvider(new EmptyItemProvider());
        addItemProvider(new HorizontalScrollCardItemProvider());//头部广告
        addItemProvider(new AutoPlayVideoAdItemProvider());//视频广告
        addItemProvider(new TopCategoriesItemProvider());//热门分类
        addItemProvider(new ColumnCardListItemProvider());//专题策划
        addItemProvider(new TextCardItemProvider());//文字卡
        addItemProvider(new BannerItemProvider());
        addItemProvider(new VideoSmallCardItemProvider());//视频卡
        addItemProvider(new BriefCardItemProvider());//主题卡
        addItemProvider(new FollowCardItemProvider());
        addItemProvider(new InformationCardItemProvider());
        addItemProvider(new HEADER5ItemProvider());
        addItemProvider(new FOOTER3ItemProvider());
        addItemProvider(new FOOTER2ItemProvider());
        addItemProvider(new UgcSelectedCardItemProvider());
    }

    @Override
    protected int getItemType(@NotNull List<? extends ItemListBean> list, int i) {
        String type = list.get(i).getType();
        if (type.equals("horizontalScrollCard")) {
            return ItemViewType.HORIZONTAL_SCROLL_CARD;
        } else if (type.equals("autoPlayVideoAd")) {
            return ItemViewType.AUTO_PLAY_VIDEO_AD;
        } else if (type.equals("specialSquareCardCollection")) {
            return ItemViewType.SPECIAL_SQUARE_CARD_COLLECTION;
        } else if (type.equals("columnCardList")) {
            return ItemViewType.COLUMN_CARD_LIST;
        } else if (type.equals("banner")) {
            return ItemViewType.BANNER;
        } else if (type.equals("videoSmallCard")) {
            return ItemViewType.VIDEO_SMALL_CARD;
        } else if (type.equals("briefCard")) {
            return ItemViewType.BRIEF_CARD;
        } else if (type.equals("followCard")) {
            return ItemViewType.FOLLOW_CARD;
        } else if (type.equals("informationCard")) {
            return ItemViewType.INFORMATION_CARD;
        } else if (type.equals("textCard")) {

            String header = list.get(i).getData().getType();
            if (header.equals("header5")) {
                return ItemViewType.HEADER_5;
            } else if (header.equals("footer3")) {
                return ItemViewType.FOOTER_3;
            } else if (header.equals("footer2")) {
                return ItemViewType.FOOTER_2;
            }

            return ItemViewType.TEXT_CARD;
        } else if (type.equals("ugcSelectedCardCollection")){
            return ItemViewType.UGC_SELECTED_CARD_COLLECTION;
        }
        return 0;
    }
}
