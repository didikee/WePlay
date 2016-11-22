package com.didikee.weplay.ui.fragment;

import android.support.v7.widget.RecyclerView;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;

/**
 * Created by didik on 2016/11/22.
 */

public class FavoriteFragment extends BaseFragment{

    private RecyclerView mRV;

    @Override
    protected int setLayoutResId() {
        return R.layout.frag_favorite;
    }

    @Override
    protected void initView() {
        mRV = ((RecyclerView) content.findViewById(R.id.recyclerView));
    }

    @Override
    protected void startFlow() {

    }
}
