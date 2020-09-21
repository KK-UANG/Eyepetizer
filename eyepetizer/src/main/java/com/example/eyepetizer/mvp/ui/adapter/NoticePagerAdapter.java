package com.example.eyepetizer.mvp.ui.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eyepetizer.mvp.ui.fragment.home.DailyFragment;
import com.example.eyepetizer.mvp.ui.fragment.home.FindFragment;
import com.example.eyepetizer.mvp.ui.fragment.home.RecommendFragment;
import com.example.eyepetizer.mvp.ui.fragment.notice.InteractiveFragment;
import com.example.eyepetizer.mvp.ui.fragment.notice.PrivateLettersFragment;
import com.example.eyepetizer.mvp.ui.fragment.notice.PushFragment;

import java.util.ArrayList;
import java.util.List;

public class NoticePagerAdapter extends FragmentPagerAdapter {

    private String[] mTab = {"推送", "互动", "私信"};
    private List<Fragment> mFragments = new ArrayList<>();

    public NoticePagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(PushFragment.newInstance());
        mFragments.add(InteractiveFragment.newInstance());
        mFragments.add(PrivateLettersFragment.newInstance());
    }

    @Override
    public Fragment getItem(int i) {
        if (mFragments != null && mFragments.size() > 0) {
            return mFragments.get(i);
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTab[position];
    }

    @Override
    public int getCount() {
        return mTab.length;
    }
}
