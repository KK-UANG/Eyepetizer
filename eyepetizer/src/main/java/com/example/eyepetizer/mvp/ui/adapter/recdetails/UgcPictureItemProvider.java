package com.example.eyepetizer.mvp.ui.adapter.recdetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.bean.ItemListBean;
import com.example.eyepetizer.mvp.ui.adapter.home.HorizontalScrollCardItemProvider;
import com.example.eyepetizer.mvp.utils.ItemViewType;
import com.jess.arms.http.imageloader.glide.ImageConfigImpl;
import com.jess.arms.utils.ArmsUtils;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class UgcPictureItemProvider extends BaseItemProvider<ItemListBean> {
    @Override
    public int getItemViewType() {
        return ItemViewType.UGC_PICTURE;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_ugc_picture;
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

        MZBannerView banner = holder.getView(R.id.MZBannerView);
        banner.setIndicatorVisible(false);
        List<String> urls = bean.getUrls();
        holder.setVisible(R.id.tvPhotoCount, urls.size() > 1);
        holder.setText(R.id.tvPhotoCount, "1/" + urls.size());
        banner.setPages(urls, (MZHolderCreator<BannerViewHolder>) () -> new BannerViewHolder());

        banner.addPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                holder.setText(R.id.tvPhotoCount, position + 1 + "/" + urls.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public static class BannerViewHolder implements MZViewHolder<String> {
        private ImageView mImageView;

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_ugc_picture, null);
            mImageView = view.findViewById(R.id.imageView);
            return view;
        }

        @Override
        public void onBind(Context context, int position, String url) {
            ArmsUtils.obtainAppComponentFromContext(context)
                    .imageLoader()
                    .loadImage(context, ImageConfigImpl
                            .builder()
                            .isCrossFade(true)
                            .imageView(mImageView)
                            .url(url)
                            .build());
        }
    }
}
