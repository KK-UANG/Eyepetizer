package com.example.eyepetizer.mvp.ui.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.utils.Utils;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AttentionAdapter extends BaseQuickAdapter<ItemListBean, BaseViewHolder> implements LoadMoreModule {

    public AttentionAdapter() {
        super(R.layout.adapter_item_attention);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        ItemListBean.DataBean bean = data.getData();
        ItemListBean.DataBean dataBean = bean.getContent().getData();

        holder.setText(R.id.tvNickname, bean.getHeader().getIssuerName())
                .setText(R.id.tvContent, dataBean.getDescription())
                .setText(R.id.tvTitle, dataBean.getTitle())
                .setText(R.id.tvCollectionCount, String.valueOf(dataBean.getConsumption().getCollectionCount()))
                .setText(R.id.tvReplyCount, String.valueOf(dataBean.getConsumption().getReplyCount()))
                .setText(R.id.tvVideoDuration, Utils.format(dataBean.getDuration()));

        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .isCircle(true)
                        .placeholder(R.drawable.ic_avatar_gray_76dp)
                        .imageView(holder.getView(R.id.ivAvatar))
                        .url(bean.getHeader().getIcon())
                        .build());

        GSYVideoPlayer player = holder.getView(R.id.videoPlayer);
        ImageView cover = new ImageView(getContext());
        cover.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .isCrossFade(true)
                        .imageView(cover)
                        .url(dataBean.getCover().getFeed())
                        .build());

        player.setUp(dataBean.getPlayUrl(), false, null);
        player.setLooping(false);
        player.setPlayTag("AttentionAdapter");
        player.setPlayPosition(holder.getAdapterPosition());
        player.setThumbImageView(cover);
        player.getBackButton().setVisibility(View.GONE);
        player.getFullscreenButton().setVisibility(View.GONE);

        player.setVideoAllCallBack(new GSYSampleCallBack() {

            @Override
            public void onStartPrepared(String url, Object... objects) {
                super.onStartPrepared(url, objects);
                holder.setVisible(R.id.tvVideoDuration, false);
                GSYVideoManager.instance().setNeedMute(true);
            }

            @Override
            public void onPrepared(String url, Object... objects) {
                super.onPrepared(url, objects);
                GSYVideoManager.instance().setNeedMute(true);
            }

        });
    }

}
