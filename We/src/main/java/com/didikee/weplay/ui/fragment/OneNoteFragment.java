package com.didikee.weplay.ui.fragment;

import android.content.Intent;
import android.view.View;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;
import com.didikee.weplay.test.TestLife2Activity;

public class OneNoteFragment extends BaseFragment {
    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_one_note;
    }

    @Override
    protected void initView() {
        content.findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), TestLife2Activity.class));
            }
        });
    }

    @Override
    protected void startFlow() {

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
