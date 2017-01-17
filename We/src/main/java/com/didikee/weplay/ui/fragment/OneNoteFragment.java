package com.didikee.weplay.ui.fragment;

import android.view.View;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;

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
