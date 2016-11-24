package com.didikee.weplay.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.didikee.weplay.R;
import com.didikee.weplay.ui.views.iview.OnFavoriteHumanClickListener;

/**
 * Created by didik on 2016/11/22.
 */

public class FavoriteHumanLayout extends LinearLayout implements View.OnClickListener {

    private TextView tv_name;
    private OnFavoriteHumanClickListener mListener;

    public FavoriteHumanLayout(Context context) {
        this(context,null);
    }

    public FavoriteHumanLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public FavoriteHumanLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.layout_favorite_human,this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tv_name = ((TextView) findViewById(R.id.tv_name));
        tv_name.setText("Didikee");

        findViewById(R.id.ll_note).setOnClickListener(this);
        findViewById(R.id.ll_like).setOnClickListener(this);
        findViewById(R.id.ll_sad).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mListener==null)return;
        switch (view.getId()){
            case R.id.ll_note:
                mListener.onNoteClick(view,0L);
                break;
            case R.id.ll_like:
                mListener.onLikeClick(view,0L);
                break;
            case R.id.ll_sad:
                mListener.onSadClick(view,0L);
                break;
        }
    }

    public void setOnFavoriteHumanClickListener(OnFavoriteHumanClickListener listener){
        this.mListener=listener;
    }

}
