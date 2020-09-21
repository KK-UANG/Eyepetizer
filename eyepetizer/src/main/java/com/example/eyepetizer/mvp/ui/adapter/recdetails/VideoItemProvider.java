package com.example.eyepetizer.mvp.ui.adapter.recdetails;

import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VideoItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.VIDEO;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_video;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        ItemListBean.DataBean bean = data.getData().getContent().getData();
        holder.setText(R.id.tvNickName, bean.getOwner().getNickname())
                .setText(R.id.tvDescription, bean.getDescription())
                .setText(R.id.tvCollectionCount, String.valueOf(bean.getConsumption().getCollectionCount()))
                .setText(R.id.tvReplyCount, String.valueOf(bean.getConsumption().getReplyCount()));
        if (bean.getTags() == null) {
            holder.setVisible(R.id.tvTagName, false);
        } else {
            holder.setText(R.id.tvTagName, bean.getTags().get(0).getName());
        }
        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .url(bean.getOwner().getAvatar())
                        .imageView(holder.getView(R.id.ivAvatar))
                        .isCrossFade(true)
                        .isCircle(true)
                        .placeholder(R.drawable.ic_avatar_gray_76dp)
                        .build());

        GSYVideoPlayer player = holder.getView(R.id.videoPlayer);
        player.setUp(bean.getPlayUrl(), false, null);
        player.setLooping(false);
        player.setPlayTag("VideoItemProvider");
        player.setPlayPosition(holder.getAdapterPosition());
        player.getBackButton().setVisibility(View.GONE);
        player.getFullscreenButton().setVisibility(View.GONE);
    }


}
