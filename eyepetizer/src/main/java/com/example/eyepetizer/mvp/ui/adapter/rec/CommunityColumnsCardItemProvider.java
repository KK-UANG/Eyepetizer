package com.example.eyepetizer.mvp.ui.adapter.rec;

import android.content.Intent;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.DataBean;
import com.example.eyepetizer.mvp.api.entity.PushBean;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.activity.RecDetailsActivity;
import com.example.eyepetizer.mvp.ui.fragment.community.RecFragment;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.List;

public class CommunityColumnsCardItemProvider extends BaseItemProvider<ItemListBean> {


    @Override
    public int getItemViewType() {
        return ItemViewType.COMMUNITY_COLUMNS_CARD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_community_columns;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, @Nullable ItemListBean data) {
        holder.setText(R.id.tvDescription, data.getData().getContent().getData().getDescription())
                .setText(R.id.tvNickName, data.getData().getContent().getData().getOwner().getNickname())
                .setText(R.id.tvCollectionCount, String.valueOf(data.getData().getContent().getData().getConsumption().getCollectionCount()))
                .setVisible(R.id.tvChoiceness, data.getData().getContent().getData().getLibrary().equals("DAILY"));

        int height = data.getData().getContent().getData().getHeight();
        int width = data.getData().getContent().getData().getWidth();
        int i = 0;
        if (height != 0 || width != 0) {
            i = height / width;
        }
        ImageView view = holder.getView(R.id.ivBgPicture);
        view.getLayoutParams().height = i == 0 ? 600 : (600 * i);
        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .url(data.getData().getContent().getData().getCover().getFeed())
                        .imageView(view)
                        .imageRadius(10)
                        .isCrossFade(true)
                        .build());

        ArmsUtils.obtainAppComponentFromContext(getContext())
                .imageLoader()
                .loadImage(getContext(), ImageConfigImpl
                        .builder()
                        .url(data.getData().getContent().getData().getOwner().getAvatar())
                        .imageView(holder.getView(R.id.ivRoundAvatar))
                        .isCrossFade(true)
                        .isCircle(true)
                        .placeholder(R.drawable.ic_avatar_gray_76dp)
                        .build());
    }

}
