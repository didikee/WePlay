package com.didikee.weplay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import com.didikee.weplay.R;
import com.didikee.weplay.custom.WrapContentViewPager;

public class MainActivity extends AppCompatActivity {
    private final String TAG=getClass().getSimpleName();
    private TabLayout mTabLayout;
    private WrapContentViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, WEActivity.class));

//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolBar);
//        mToolbar.setTitleTextColor(Color.WHITE);//设置ToolBar的titl颜色
//        setSupportActionBar(mToolbar);
//
//        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
//        mViewPager= (WrapContentViewPager) findViewById(R.id.viewPager);
//
//        MainPagerAdapter pagerAdapter=new MainPagerAdapter(getSupportFragmentManager());
//        mViewPager.setAdapter(pagerAdapter);
//        //TODO fragment
//        final WeFragment oneFragment=new WeFragment();
//        final ActItemFragment twoFragment=new ActItemFragment();
//        final OneFragment threeFragment=new OneFragment();
//        List<Fragment> fragments=new ArrayList<>();
//        fragments.add(oneFragment);
//        fragments.add(twoFragment);
//        fragments.add(threeFragment);
//        pagerAdapter.addFragment(fragments);
//        mTabLayout.setupWithViewPager(mViewPager);
//
//        mTabLayout.getTabAt(0).setIcon(getResources().getDrawable(R.drawable.ic_menu_person));
//        mTabLayout.getTabAt(1).setIcon(getResources().getDrawable(R.drawable.ic_menu_person));
//        mTabLayout.getTabAt(2).setIcon(getResources().getDrawable(R.drawable.ic_menu_person));
//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolBar);
//        mToolbar.setTitleTextColor(Color.WHITE);//设置ToolBar的titl颜色
//        setSupportActionBar(mToolbar);

//        startActivity(new Intent(this, TestLifeActivity.class));

    }
}