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

public class VideoSmallCardItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.VIDEO_SMALL_CARD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_video_card;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        holder.setText(R.id.tv_video_title, data.getData().getTitle())
                .setText(R.id.tv_video_play_time, Utils.format(data.getData().getDuration()))
                .setText(R.id.tv_video_description, data.getData().getAuthor().getName() + " / # " + data.getData().getCategory());
        ArmsUtils.obtainAppComponentFromContext(context)
                .imageLoader()
                .loadImage(context, ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageRadius(10)
                        .imageView(holder.getView(R.id.iv_video_card))
                        .url(data.getData().getCover().getFeed())
                        .build());
    }


    @Override
    public void onClick(@NotNull BaseViewHolder helper, @NotNull View view, ItemListBean data, int position) {
        super.onClick(helper, view, data, position);
        Intent intent = new Intent(getContext(), VideoActivity.class);
        intent.putExtra(VideoActivity.PLAY_URL, data.getData().getPlayUrl());
        ArmsUtils.startActivity(intent);
    }
}
