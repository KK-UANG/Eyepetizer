package com.example.eyepetizer.mvp.ui.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.eyepetizer.mvp.ui.fragment.community.AttentionFragment;
import com.example.eyepetizer.mvp.ui.fragment.community.RecFragment;

import java.util.ArrayList;
import java.util.List;

public class CommunityPagerAdapter extends FragmentPagerAdapter {

    private String[] mTab = {"推荐", "关注"};
    private List<Fragment> mFragments = new ArrayList<>();

    public CommunityPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments.add(RecFragment.newInstance());
        mFragments.add(AttentionFragment.newInstance());
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
