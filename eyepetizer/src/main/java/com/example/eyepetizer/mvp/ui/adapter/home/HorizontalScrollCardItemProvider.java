package com.example.eyepetizer.mvp.ui.adapter.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.activity.WebViewActivity;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.jetbrains.annotations.NotNull;

public class HorizontalScrollCardItemProvider extends BaseItemProvider<ItemListBean> {

    @Override
    public int getItemViewType() {
        return ItemViewType.HORIZONTAL_SCROLL_CARD;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_card_head;
    }

    @Override
    public void convert(@NotNull BaseViewHolder holder, ItemListBean data) {
        MZBannerView banner = holder.getView(R.id.vp_card_head);

        banner.setBannerPageClickListener(((view, position) -> {
            String actionUrl = data.getData().getItemList().get(position).getData().getActionUrl();
            if (actionUrl.contains("webview")) {
                Intent intent = new Intent(getContext(), WebViewActivity.class);
                intent.putExtra(WebViewActivity.ACTION_URL, actionUrl);
                ArmsUtils.startActivity(intent);
            }
        }));

        banner.setIndicatorVisible(false);
        banner.setPages(data.getData().getItemList(), (MZHolderCreator<BannerViewHolder>) () -> new BannerViewHolder());
    }


    public static class BannerViewHolder implements MZViewHolder<ItemListBean> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_card_head, null);
            mImageView = view.findViewById(R.id.iv_card_head);
            return view;
        }

        @Override
        public void onBind(Context context, int position, ItemListBean data) {
            ArmsUtils.obtainAppComponentFromContext(context)
                    .imageLoader()
                    .loadImage(context, ImageConfigImpl
                            .builder()
                            .isCrossFade(true)
                            .imageRadius(10)
                            .imageView(mImageView)
                            .url(data.getData().getImage())
                            .build());
        }
    }
}
