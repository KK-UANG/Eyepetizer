package com.example.eyepetizer.mvp.ui.adapter.home;

import android.content.Intent;
import android.view.View;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.activity.VideoActivity;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.example.eyepetizer.mvp.utils.Utils;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FollowCardItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.FOLLOW_CARD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_follow_card;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        holder.setText(R.id.tv_title, data.getData().getHeader().getTitle())
                .setText(R.id.tv_video_duration, Utils.format(data.getData().getContent().getData().getDuration()))
                .setText(R.id.tv_description, data.getData().getHeader().getDescription());
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context, ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageRadius(10)
                        .imageView(holder.getView(R.id.iv_video))
                        .url(data.getData().getContent().getData().getCover().getFeed())
                        .build());
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context, ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .isCircle(true)
                        .placeholder(R.drawable.ic_avatar_gray_76dp)
                        .imageView(holder.getView(R.id.iv_avatar))
                        .url(data.getData().getHeader().getIcon())
                        .build());
    }

    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, ItemListBean data, int position) {
        super.onClick(helper, view, data, position);
        Intent intent = new Intent(getContext(), VideoActivity.class);
        intent.putExtra(VideoActivity.PLAY_URL, data.getData().getContent().getData().getPlayUrl());
        ArmsUtils.startActivity(intent);
    }
}
