package com.example.eyepetizer.mvp.ui.player;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.eyepetizer.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.NetworkUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;

public class PagerScrolling {


    public void onPageSelected(ViewPager2 viewPager, int position) {
        for (int i = 0; i < viewPager.getChildCount(); i++) {
            View view = viewPager.getChildAt(i);
            if (view != null && view instanceof RecyclerView) {
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
                int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
                for (int i1 = 0; i1 < childCount; i1++) {
                    if (layoutManager.getChildAt(i1) != null
                            && layoutManager.getChildAt(i1).findViewById(R.id.videoPlayer) != null) {
                        GSYBaseVideoPlayer player
                                = (GSYBaseVideoPlayer) layoutManager.getChildAt(position).findViewById(R.id.videoPlayer);

                        int playPosition = player.getPlayPosition();
                        Log.d("数据1", "String.valueOf(playPosition)");
                        if (playPosition == position) {
                            Rect rect = new Rect();
                            player.getLocalVisibleRect(rect);
                            int height = player.getHeight();
                            boolean isPlayerVisible = rect.top == 0 && rect.bottom == height;
                            int currentState = player.getCurrentPlayer().getCurrentState();
                            if (isPlayerVisible
                                    && player.getVisibility() == View.VISIBLE
                                    && (currentState == GSYBaseVideoPlayer.CURRENT_STATE_NORMAL
                                    || currentState == GSYBaseVideoPlayer.CURRENT_STATE_ERROR)) {
                                startPlayLogic(player, player.getContext());
                            }
                        }
                    } else {
                        GSYVideoManager.onPause();
                        Log.d("数据111", "String.valueOf(playPosition)");
                    }
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
