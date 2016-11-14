package com.didikee.weplay.test;

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
        setULeftTitle("Hello","World",R.drawable.ic_left_orange_arrow);
    }

    @Override
    protected void onULeftClick(View v, int index) {
        super.onULeftClick(v, index);
        Toast.makeText(this, "index: "+index, Toast.LENGTH_SHORT).show();
    }
}
