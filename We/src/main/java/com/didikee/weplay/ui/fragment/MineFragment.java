package com.didikee.weplay.ui.fragment;

import android.widget.TextView;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;

/**
 * Created by didik on 2016/11/22.
 */

public class MineFragment extends BaseFragment {

    private TextView tv_name;

    @Override
    protected int setLayoutResId() {
        return R.layout.frag_mine;
    }

    @Override
    protected void initView() {
        tv_name = (TextView) content.findViewById(R.id.tv_name);
    }

    @Override
    protected void startFlow() {
    String str="Hello World!"+"\n"+"Second Line"+"\n";
        tv_name.setText(str);
    }
}
