package com.didikee.weplay.base;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.didikee.uilibs.utils.DisplayUtil;

/**
 * Created by didik on 2016/11/14.
 */

public abstract class IBaseActivity extends AppCompatActivity {

    private  int mHeight;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(0);
        startFlow();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LinearLayout mBaseContent = new LinearLayout(this);
        mBaseContent.setOrientation(LinearLayout.VERTICAL);
        int fromLayoutId = setContentLayout();
        View fromLayout = LayoutInflater.from(this).inflate(fromLayoutId, null);
        View defaultTitleView = setDefaultTitleView();
        mHeight = DisplayUtil.dp2px(this, 48);
        mBaseContent.addView(defaultTitleView,0,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,mHeight));
        mBaseContent.addView(fromLayout,1);
        setContentView(mBaseContent);
    }

    protected abstract void setUMiddleTitle(CharSequence title, int gravity);
    protected abstract void setULeftTitle(Object... model);
    protected abstract void setURightTitle(Object... model);

    protected abstract void onULeftClick(View v,int index);
    protected abstract void onURightClick(View v,int index);

    protected abstract View setDefaultTitleView();
    protected abstract @LayoutRes int setContentLayout();
    protected abstract void startFlow();
    public int getTitleHeight(){
        return mHeight;
    }

    protected abstract @DrawableRes int setTitleItemBackground();
}
