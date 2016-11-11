package com.didikee.weplay.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by didik on 2016/11/8.
 */

public class MainPagerAdapter extends FragmentPagerAdapter{
    private String[] mTitles = new String[]{"唐僧", "大师兄", "二师兄"};

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
