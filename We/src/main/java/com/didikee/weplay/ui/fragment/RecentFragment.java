package com.didikee.weplay.ui.fragment;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;

/**
 * Created by didik on 2016/11/22.
 */

public class RecentFragment extends BaseFragment {
    @Override
    protected int setLayoutResId() {
        return R.layout.frag_recent;
    }

    @Override
    protected void initView() {
        initToolBar();
    }

    @Override
    protected void startFlow() {

    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) content.findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_app);//设置导航栏图标
//        toolbar.setLogo(R.mipmap.ic_launcher);//设置app logo
//        toolbar.setTitle("Title");//设置主标题
//        toolbar.setSubtitle("Subtitle");//设置子标题

        toolbar.inflateMenu(R.menu.menu_toolbar_we);//设置右上角的填充菜单
//        toolbar.
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int menuItemId = item.getItemId();
                if (menuItemId == R.id.action_search) {
                    Toast.makeText(getActivity() , "1" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_notification) {
                    Toast.makeText(getActivity() , "2" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_item1) {
                    Toast.makeText(getActivity() , "hide1" , Toast.LENGTH_SHORT).show();

                } else if (menuItemId == R.id.action_item2) {
                    Toast.makeText(getActivity() , "hide2" , Toast.LENGTH_SHORT).show();

                }
                return true;
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "nav", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
