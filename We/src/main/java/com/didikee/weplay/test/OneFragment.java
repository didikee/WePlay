package com.didikee.weplay.test;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;

/**
 * Created by didik on 2016/9/19.
 */
public class OneFragment extends BaseFragment {

    private TextView tv_toast;

    @Override
    protected int setLayoutResId() {
        return R.layout.test_frag;
    }

    @Override
    protected void initView() {
        tv_toast = ((TextView) content.findViewById(R.id.tv_toast));
        tv_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Hello World!", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getActivity(), TestLife2Activity.class));
                startActivity(new Intent(getActivity(), TabLayoutActivity.class));
            }
        });
    }

    @Override
    protected void startFlow() {

    }

}
