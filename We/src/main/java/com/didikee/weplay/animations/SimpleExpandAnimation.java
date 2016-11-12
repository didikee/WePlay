package com.didikee.weplay.animations;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by didik on 2016/11/12.
 */

public class SimpleExpandAnimation implements BaseAnimation {
    private final String TAG = getClass().getSimpleName();
    private int start = 0;
    private int end = 0;
    private Animator.AnimatorListener mAnimationListener;

    private SimpleExpandAnimation() {
    }

    public SimpleExpandAnimation(float start, float end) {
        this.start = (int) start;
        this.end = (int) end;
    }

    @Override
    public Animator[] getAnimators(final View view) {
        if (start ==end)return null;
        ValueAnimator animator =null;
        if (view instanceof ViewGroup){
            animator = ValueAnimator.ofInt(start, end);
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int animatedValue = (int) animation.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height=animatedValue;
                    view.setLayoutParams(layoutParams);
                }
            });
            animator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    if (mAnimationListener!=null)mAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    if (mAnimationListener!=null)mAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    if (mAnimationListener!=null)mAnimationListener.onAnimationCancel(animation);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    if (mAnimationListener!=null)mAnimationListener.onAnimationRepeat(animation);
                }
            });
        }
        return new Animator[]{animator};
    }

    public void addListener(Animator.AnimatorListener listener){
        this.mAnimationListener=listener;
    }
}
