package com.didikee.weplay.custom.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by didik on 2016/11/23.
 */

public class RVItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int mOrientation = VERTICAL;

    private Drawable mDivider;

    private int left = 0;
    private int top = 0;
    private int right = 0;
    private int bottom = 0;

    public RVItemDecoration(Context context) {
        final TypedArray ta = context.obtainStyledAttributes(ATRRS);
        this.mDivider = ta.getDrawable(0);
        ta.recycle();
    }

    public RVItemDecoration(Drawable drawable){
        this.mDivider=drawable;
    }

    public RVItemDecoration(int orientation, int sample) {
        if (orientation == HORIZONTAL) {
            left = right = sample;
        } else {
            top = bottom = sample;
        }
    }

    public void setOffset(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    //我们通过获取系统属性中的listDivider来添加，在系统中的AppTheme中设置
    public static final int[] ATRRS = new int[]{
            android.R.attr.listDivider
    };

    public void setOrientation(int orientation) {
        if (orientation != HORIZONTAL && orientation != VERTICAL) return;
        mOrientation = orientation;
    }

    /**
     * 该方法会在绘制 item 之前调用，绘制范围是 RecyclerView 范围内的任意位置，不局限在 item 中.
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mOrientation == HORIZONTAL) {
            drawVerticalLine(c, parent, state);
        } else {
            drawHorizontalLine(c, parent, state);
        }
    }

    /**
     * 该方法会在 item 绘制完之后调用，绘制在最上层.
     * @param c canvas
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    /**
     * @param outRect outRect{left,top,right,bottom} 中设置要绘制的分割线的宽度.
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State
            state) {
        if (mDivider != null) {
            if (mOrientation == HORIZONTAL) {
                //画横线，就是往下偏移一个分割线的高度
                outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
            } else {
                //画竖线，就是往右偏移一个分割线的宽度
                outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
            }
        } else {
//            int childCount = parent.getChildCount(); 这个数量是不对的.
            int childCount = parent.getAdapter().getItemCount();
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = 0;
                outRect.top = 0;
                outRect.right = mOrientation == HORIZONTAL ? right : 0;
                outRect.bottom = mOrientation == HORIZONTAL ? 0 : bottom;
            } else if (childAdapterPosition == childCount - 1) {
                outRect.left = mOrientation == HORIZONTAL ? left : 0;
                outRect.top = mOrientation == HORIZONTAL ? 0 : top;
                outRect.right = 0;
                outRect.bottom = 0;
            } else {
                outRect.left = mOrientation == HORIZONTAL ? left : 0;
                outRect.top = mOrientation == HORIZONTAL ? 0 : top;
                outRect.right = mOrientation == HORIZONTAL ? right : 0;
                outRect.bottom = mOrientation == HORIZONTAL ? 0 : bottom;
            }
        }

    }

    //画横线, 这里的parent其实是显示在屏幕显示的这部分
    public void drawHorizontalLine(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mDivider == null) return;
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);

            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
            //Log.d("wnw", left + " " + top + " "+right+"   "+bottom+" "+i);
        }
    }

    //画竖线
    public void drawVerticalLine(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (mDivider == null) return;
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);

            //获得child的布局信息
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
                    .getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }
}
