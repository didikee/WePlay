package com.didikee.weplay.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by didik on 2016/11/8.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{
    private String[] mTitles = new String[]{"WE", "MORE", "ME"};

    private List<Fragment> fragments;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(List<Fragment> fragments){
        this.fragments=fragments;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0:fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
