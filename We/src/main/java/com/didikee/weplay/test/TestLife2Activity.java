package com.didikee.weplay.test;

import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.didikee.weplay.R;
import com.didikee.weplay.base.SimpleBaseActivity;

public class TestLife2Activity extends SimpleBaseActivity {

    @Override
    protected int setContentLayout() {
        return R.layout.activity_test_life2;
    }

    @Override
    protected void startFlow() {

        setURightTitle("Hello","World",R.drawable.ic_menu_star);
        setUMiddleTitle("We Are Young!", Gravity.LEFT);
    }

    @Override
    protected boolean setUMiddleTitleMode() {
        return false;
    }

    @Override
    protected void onULeftClick(View v, int index) {
        super.onULeftClick(v, index);
        Toast.makeText(this, "index: "+index, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onURightClick(View v, int index) {
        super.onURightClick(v, index);
        Toast.makeText(this, "index: "+index, Toast.LENGTH_SHORT).show();
        if (index==3){
            setULeftTitle(R.drawable.ic_left_orange_arrow);
        }
    }
}
