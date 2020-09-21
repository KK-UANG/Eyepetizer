package com.example.eyepetizer.mvp.ui.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eyepetizer.mvp.ui.fragment.home.DailyFragment;
import com.example.eyepetizer.mvp.ui.fragment.home.FindFragment;
import com.example.eyepetizer.mvp.ui.fragment.home.RecommendFragment;

import java.util.ArrayList;
import java.util.List;

public class HomePagerAdapter extends FragmentPagerAdapter {

    private String[] mTab = {"发现", "推荐", "日报"};
    private List<Fragment> mFragments = new ArrayList<>();

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(FindFragment.newInstance());
        mFragments.add(RecommendFragment.newInstance());
        mFragments.add(DailyFragment.newInstance());
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
