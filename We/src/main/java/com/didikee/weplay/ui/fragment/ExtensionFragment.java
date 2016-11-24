package com.didikee.weplay.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;
import com.didikee.weplay.test.TabLayoutActivity;

/**
 * Created by didik on 2016/11/22.
 */

public class ExtensionFragment  extends BaseFragment {

    private TextView tv_temp;

    @Override
    protected int setLayoutResId() {
        return R.layout.frag_extension;
    }

    @Override
    protected void initView() {
        tv_temp = ((TextView) content.findViewById(R.id.tv_temp));
    }

    @Override
    protected void startFlow() {
        tv_temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "DO NOT CLICK !", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), TabLayoutActivity.class));
            }
        });
    }
}
