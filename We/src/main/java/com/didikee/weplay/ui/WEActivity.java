package com.didikee.weplay.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.didikee.weplay.R;
import com.didikee.weplay.custom.bottom.BottomNavigationView;
import com.didikee.weplay.ui.fragment.ExtensionFragment;
import com.didikee.weplay.ui.fragment.FavoriteFragment;
import com.didikee.weplay.ui.fragment.MineFragment;
import com.didikee.weplay.ui.fragment.RecentFragment;

import java.util.HashMap;

public class WEActivity extends AppCompatActivity {

    private HashMap<Integer,Fragment> frags=new HashMap<>();
    private FragmentManager fm;
    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we);

        fm = getSupportFragmentManager();
        initBottomNav();

        MenuItem firstMenuItem = bottomNav.getMenu().getItem(0);
        bottomNavListener.onNavigationItemSelected(firstMenuItem);

    }

    private void initBottomNav() {
        bottomNav = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNav.setOnNavigationItemSelectedListener(bottomNavListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_recent:
                    showFragment(R.id.action_recent);
                    break;
                case R.id.action_favorite:
                    showFragment(R.id.action_favorite);
                    break;
                case R.id.action_extension:
                    showFragment(R.id.action_extension);
                    break;
                case R.id.action_mine:
                    showFragment(R.id.action_mine);
                    break;
            }
            return true;
        }
    };

    private void showFragment(int id){
        Fragment fragment = frags.get(id);
        if (fragment ==null){
            switch (id){
                case R.id.action_recent:
                    fragment =new RecentFragment();
                    break;
                case R.id.action_favorite:
                    fragment= new FavoriteFragment();
                    break;
                case R.id.action_extension:
                    fragment= new ExtensionFragment();
                    break;
                case R.id.action_mine:
                    fragment=new MineFragment();
                    break;
            }
            frags.put(id,fragment);
        }
        fm.beginTransaction().replace(R.id.fl_container,fragment,id+"").commit();
    }

}
