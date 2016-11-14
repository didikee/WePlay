package com.didikee.weplay.custom.expand;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by didik on 2016/11/12.
 */

public abstract class BaseExpandLayout extends FrameLayout implements Expandable{
    protected static final int EXPAND=0x0;
    protected static final int SHRINK=0x1;

    public BaseExpandLayout(Context context) {
        super(context);
    }

    public BaseExpandLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseExpandLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
