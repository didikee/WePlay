package com.didikee.weplay.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by didik on 2016/11/9.
 */

public abstract class BaseFragment extends Fragment {

    private View mContent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mContent = inflater.inflate(setLayoutResId(), container, false);
        initView(mContent);
        return mContent;
    }

    protected abstract int setLayoutResId();

    protected abstract void initView(View content);
}
