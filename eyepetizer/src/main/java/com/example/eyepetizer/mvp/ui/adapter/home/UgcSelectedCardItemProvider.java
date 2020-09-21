package com.example.eyepetizer.mvp.ui.adapter.home;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.ImageLoader;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UgcSelectedCardItemProvider extends BaseItemProvider<ItemListBean> {
    @Override
    public int getItemViewType() {
        return ItemViewType.UGC_SELECTED_CARD_COLLECTION;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_ugc_selected;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        List<ItemListBean> itemList = data.getData().getItemList();
        holder.setText(R.id.tvTitle, data.getData().getHeader().getTitle())
                .setText(R.id.tvRightText, data.getData().getHeader().getRightText())
                .setText(R.id.tvNicknameLeft, itemList.get(0).getData().getNickname())
                .setText(R.id.tvNicknameRightTop, itemList.get(1).getData().getNickname())
                .setText(R.id.tvNicknameRightBottom, itemList.get(2).getData().getNickname());

        ImageLoader imageLoader = ArmsUtils.obtainAppComponentFromContext(context).imageLoader();

        imageLoader.loadImage(context, ImageConfigImpl
                .builder()
                .isCrossFade(true)
                .imageView(holder.getView(R.id.ivCoverLeft))
                .url(itemList.get(0).getData().getUrl())
                .build());
        imageLoader.loadImage(context, ImageConfigImpl
                .builder()
                .isCrossFade(true)
                .isCircle(true)
                .imageView(holder.getView(R.id.ivAvatarLeft))
                .url(itemList.get(0).getData().getUserCover())
                .build());

        imageLoader.loadImage(context, ImageConfigImpl
                .builder()
                .isCrossFade(true)
                .imageView(holder.getView(R.id.ivCoverRightTop))
                .url(itemList.get(1).getData().getUrl())
                .build());
        imageLoader.loadImage(context, ImageConfigImpl
                .builder()
                .isCrossFade(true)
                .isCircle(true)
                .imageView(holder.getView(R.id.ivAvatarRightTop))
                .url(itemList.get(1).getData().getUserCover())
                .build());

        imageLoader.loadImage(context, ImageConfigImpl
                .builder()
                .isCrossFade(true)
                .imageView(holder.getView(R.id.ivCoverRightBottom))
                .url(itemList.get(2).getData().getUrl())
                .build());
        imageLoader.loadImage(context, ImageConfigImpl
                .builder()
                .isCrossFade(true)
                .isCircle(true)
                .imageView(holder.getView(R.id.ivAvatarRightBottom))
                .url(itemList.get(2).getData().getUserCover())
                .build());
    }
}
