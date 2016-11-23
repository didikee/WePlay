package com.didikee.weplay.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by didik on 2016/11/7.
 */

public class ActItemAdapter extends RecyclerView.Adapter<ActItemAdapter.Adapter>{

    @Override
    public Adapter onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Adapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Adapter extends RecyclerView.ViewHolder {
        public Adapter(View itemView) {
            super(itemView);
        }
    }
}
