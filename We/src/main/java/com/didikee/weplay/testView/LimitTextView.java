package com.didikee.weplay.testView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by didik on 2016/9/20.
 */
public class LimitTextView extends TextView {

    /** @hide */
    public static final int VIEW_STATE_WINDOW_FOCUSED = 1;
    /** @hide */
    public static final int VIEW_STATE_SELECTED = 1 << 1;
    /** @hide */
    public static final int VIEW_STATE_FOCUSED = 1 << 2;
    /** @hide */
    public static final int VIEW_STATE_ENABLED = 1 << 3;
    /** @hide */
    public static final int VIEW_STATE_PRESSED = 1 << 4;
    /** @hide */
    public static final int VIEW_STATE_ACTIVATED = 1 << 5;
    /** @hide */
    public static final int VIEW_STATE_ACCELERATED = 1 << 6;
    /** @hide */
    public static final int VIEW_STATE_HOVERED = 1 << 7;
    /** @hide */
    public static final int VIEW_STATE_DRAG_CAN_ACCEPT = 1 << 8;
    /** @hide */
    public static final int VIEW_STATE_DRAG_HOVERED = 1 << 9;
    public LimitTextView(Context context) {
        this(context,null);
    }

    public LimitTextView(Context context, AttributeSet attrs) {
        this(context, attrs,-301177);
    }

    public LimitTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        int[] drawableState = this.getDrawableState();
        Drawable background = this.getBackground();
        if (background!=null){
            Log.e("test","YYYY");
        }
        if (drawableState!=null){
            Log.e("test","ppp:"+drawableState[0]+"===="+VIEW_STATE_PRESSED);
            Log.e("test","ppp:"+drawableState[1]+"===="+(-VIEW_STATE_PRESSED));
        }



    }


}
