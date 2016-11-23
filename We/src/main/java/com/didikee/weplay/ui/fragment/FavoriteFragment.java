package com.didikee.weplay.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.didikee.uilibs.utils.DisplayUtil;
import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;
import com.didikee.weplay.base.BaseRVViewHolder;
import com.didikee.weplay.base.SimpleRVAdapter;
import com.didikee.weplay.custom.utils.RVItemDecoration;

import java.util.ArrayList;

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
        ArrayList<String> data=new ArrayList<>();
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        data.add("jj");
        SimpleRVAdapter<String> favoriteAdapter=new SimpleRVAdapter<String>(getContext(),R.layout.rv_item_favorite) {
            @Override
            protected void bindView(BaseRVViewHolder helper, String item) {

            }
        };
        mRV.setHasFixedSize(true);
        mRV.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRV.addItemDecoration(new RVItemDecoration(RVItemDecoration.VERTICAL, DisplayUtil.dp2px(getContext(),1.5f)));
        favoriteAdapter.setData(data);
        mRV.setAdapter(favoriteAdapter);
    }
}
