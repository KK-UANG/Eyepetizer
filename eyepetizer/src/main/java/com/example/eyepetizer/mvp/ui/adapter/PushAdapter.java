package com.example.eyepetizer.mvp.ui.adapter;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.TimeUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.eyepetizer.R;
import com.example.eyepetizer.mvp.api.entity.PushBean;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PushAdapter extends BaseQuickAdapter<PushBean.MessageListBean, BaseViewHolder> implements LoadMoreModule {

    public PushAdapter() {
        super(R.layout.adapter_item_push);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder holder, @Nullable PushBean.MessageListBean data) {
        holder.setText(R.id.tvTitle, data.getTitle())
                .setText(R.id.tvTime, TimeUtils.millis2String (data.getDate()))
                .setText(R.id.tvContent, data.getContent());
    }
}
