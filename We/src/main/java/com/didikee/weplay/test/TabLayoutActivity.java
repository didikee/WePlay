package com.didikee.weplay.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.didikee.weplay.R;
import com.didikee.weplay.test.tab.ExtTabLayout;
import com.didikee.weplay.ui.fragment.PageFragment;

public class TabLayoutActivity extends AppCompatActivity {

    private SimpleFragmentPagerAdapter pagerAdapter1;
    private SimpleFragmentPagerAdapter pagerAdapter2;

    private ViewPager viewPager;

    private ExtTabLayout tabLayout;
    private View item1;
    private View item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        startFlow();
    }

    private void startFlow() {

//        NestedScrollView scrollView = (NestedScrollView) findViewById (R.id.nestedScrollView);
//        scrollView.setFillViewport (true);
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);


        pagerAdapter1 = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), new String[]{"tab1","tab2","tab3","tab4"});
        pagerAdapter2 = new SimpleFragmentPagerAdapter(getSupportFragmentManager(), new String[]{"tab999","tab998","tab99","tab22","hhhh","us的话"});
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (ExtTabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(ExtTabLayout.MODE_FIXED);

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setAdapter(pagerAdapter1);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setAdapter(pagerAdapter2);
            }
        });
        item1.performClick();
    }



    public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

//        private String tabTitles[] = new String[]{"tab1","tab2","tab3"};
        private String tabTitles[] ;
        private Context context;

        public SimpleFragmentPagerAdapter(FragmentManager fm,String[] strings) {
            super(fm);
            tabTitles=strings;
        }

        @Override
        public Fragment getItem(int position) {
            return PageFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
