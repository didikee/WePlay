package com.didikee.weplay.ui.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.didikee.weplay.R;

/**
 * Created by didik on 2016/11/22.
 */

public class FavoriteHumanLayout extends LinearLayout {

    private TextView tv_name;

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
    }
}
