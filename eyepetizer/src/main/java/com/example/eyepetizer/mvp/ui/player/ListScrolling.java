package com.example.eyepetizer.mvp.ui.player;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eyepetizer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.NetworkUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;

public class ListScrolling {

    private int mFirstVisibleItem;
    private int mLastVisibleItem;

    public void onScrolled(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (layoutManager != null) {
            mFirstVisibleItem = layoutManager.findFirstVisibleItemPosition();
            mLastVisibleItem = layoutManager.findLastVisibleItemPosition();
        }
    }

    public void autoPlayVideo(RecyclerView recyclerView) {

        if (mFirstVisibleItem == 0 && mLastVisibleItem == 0 && recyclerView.getChildAt(0) != null) {
            GSYBaseVideoPlayer player = null;
            if (recyclerView != null && recyclerView.getChildAt(0) != null) {
                player = recyclerView.getChildAt(0).findViewById(R.id.videoPlayer);
            }
            int currentState = player.getCurrentPlayer().getCurrentState();
            if (player != null) {
                if (currentState == GSYBaseVideoPlayer.CURRENT_STATE_NORMAL
                        || currentState == GSYBaseVideoPlayer.CURRENT_STATE_ERROR) {
                    startPlayLogic(player, player.getContext());
                }
            }
        }

        for (int i = 0; i <= mLastVisibleItem; i++) {
            if (recyclerView == null || recyclerView.getChildAt(i) == null) return;
            GSYBaseVideoPlayer player = recyclerView.getChildAt(i).findViewById(R.id.videoPlayer);
            if (player != null) {
                Rect rect = new Rect();
                //获取视图本身的可见坐标，把值传入到rect对象中
                player.getLocalVisibleRect(rect);
                //获取视频的高度
                int videoHeight = player.getHeight();
                if (rect.top == 0 && rect.bottom == videoHeight) {
                    int currentState = player.getCurrentPlayer().getCurrentState();
                    if (currentState == GSYBaseVideoPlayer.CURRENT_STATE_NORMAL
                            || currentState == GSYBaseVideoPlayer.CURRENT_STATE_ERROR) {
                        startPlayLogic(player, player.getContext());
                    }
                    return;
                }
            }
        }
    }


    private void startPlayLogic(GSYBaseVideoPlayer player,
                                Context context) {
        if (!com.shuyu.gsyvideoplayer.utils.CommonUtil.isWifiConnected(context)) {
            // 这里判断是否wifi
            showWifiDialog(player, context);
            return;
        }
        player.startPlayLogic();
    }

    private void showWifiDialog(final GSYBaseVideoPlayer player, Context context) {
        if (!NetworkUtils.isAvailable(context)) {
            Toast.makeText(context, context.getResources().getString(com.shuyu.gsyvideoplayer.R.string.no_net), Toast.LENGTH_LONG).show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(context.getResources().getString(com.shuyu.gsyvideoplayer.R.string.tips_not_wifi));
        builder.setPositiveButton(context.getResources().getString(com.shuyu.gsyvideoplayer.R.string.tips_not_wifi_confirm),
                (dialog, which) -> {
                    dialog.dismiss();
                    player.startPlayLogic();
                });
        builder.setNegativeButton(context.getResources()
                        .getString(com.shuyu.gsyvideoplayer.R.string.tips_not_wifi_cancel),
                (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

}


