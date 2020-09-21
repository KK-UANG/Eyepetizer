package com.example.eyepetizer.mvp.ui.player;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

import com.example.eyepetizer.mvp.ui.fragment.community.AttentionFragment_MembersInjector;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.NetworkUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;

public class AutoPlayPageChangeListener extends OnPageChangeCallback {

    private boolean isPageSelected = false;
    private boolean isNeedShowWifiDialog = true;
    private final ViewPager2 viewPager;
    private int defaultPosition;
    private final int itemPlayId;

    public AutoPlayPageChangeListener(ViewPager2 viewPager, int defaultPosition, int itemPlayId) {
        this.viewPager = viewPager;
        this.defaultPosition = defaultPosition;
        this.itemPlayId = itemPlayId;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
        if (defaultPosition == position && positionOffsetPixels == 0) {
            onPageScrollStateChanged(ViewPager2.SCROLL_STATE_IDLE);
            defaultPosition = -1;
        }
    }

    @Override
    public void onPageSelected(int position) {
        super.onPageSelected(position);
        isPageSelected = true;
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        super.onPageScrollStateChanged(state);
        if (state == ViewPager2.SCROLL_STATE_IDLE && isPageSelected) {
            playVideo();
            isPageSelected = false;
        }
    }

    private void playVideo() {
        GSYBaseVideoPlayer gsyBaseVideoPlayer = null;
        boolean needPlay = false;
        for (int i = 0; i < viewPager.getChildCount(); i++) {
            View view = (RecyclerView) viewPager.getChildAt(i);
            if (view != null && view instanceof RecyclerView) {
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) view).getLayoutManager();
                int childCount = layoutManager != null ? layoutManager.getChildCount() : 0;
                for (int i1 = 0; i < childCount; i++) {
                    if (layoutManager.getChildAt(i1) != null
                            && layoutManager.getChildAt(i1).findViewById(itemPlayId) != null) {
                        GSYBaseVideoPlayer player =
                                (GSYBaseVideoPlayer) layoutManager.getChildAt(i)
                                        .findViewById(itemPlayId);
                        Rect rect = new Rect();
                        int position = player.getPlayPosition();
                        Log.d("数据", String.valueOf(position));
                        player.getLocalVisibleRect(rect);
                        int height = player.getHeight();
                        boolean isPlayerVisible = rect.top == 0 && rect.bottom == height;
                        if (isPlayerVisible && player.getVisibility() == View.VISIBLE
                                && (player.getCurrentPlayer().getCurrentState() == GSYBaseVideoPlayer.CURRENT_STATE_NORMAL
                                || player.getCurrentPlayer().getCurrentState() == GSYBaseVideoPlayer.CURRENT_STATE_ERROR
                                || player.getCurrentPlayer().getCurrentState() == GSYBaseVideoPlayer.CURRENT_STATE_PAUSE)) {
                            needPlay = true;
                            gsyBaseVideoPlayer = player;
                        } else {
                            GSYVideoManager.onPause();
                        }

                        if (gsyBaseVideoPlayer != null && needPlay) {
                            startPlayLogic(gsyBaseVideoPlayer, gsyBaseVideoPlayer.getContext());
                        }
                    } else {
                        GSYVideoManager.onPause();
                    }
                }
            }

        }

    }

    private void startPlayLogic(GSYBaseVideoPlayer gsyBaseVideoPlayer,
                                Context context) {
        if (!com.shuyu.gsyvideoplayer.utils.CommonUtil.isWifiConnected(context)) {
            // 这里判断是否wifi
            showWifiDialog(gsyBaseVideoPlayer, context);
            return;
        }
        gsyBaseVideoPlayer.startPlayLogic();
    }

    private void showWifiDialog(final GSYBaseVideoPlayer gsyBaseVideoPlayer,
                                Context context) {
        if (!NetworkUtils.isAvailable(context)) {
            Toast
                    .makeText(context,
                            context.getResources()
                                    .getString(com.shuyu.gsyvideoplayer.R.string.no_net),
                            Toast.LENGTH_LONG)
                    .show();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(context.getResources()
                .getString(com.shuyu.gsyvideoplayer.R.string.tips_not_wifi));
        builder.setPositiveButton(context.getResources()
                        .getString(com.shuyu.gsyvideoplayer.R.string.tips_not_wifi_confirm),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        gsyBaseVideoPlayer.startPlayLogic();
                    }
                });
        builder.setNegativeButton(context.getResources()
                        .getString(com.shuyu.gsyvideoplayer.R.string.tips_not_wifi_cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.create().show();
    }
}
