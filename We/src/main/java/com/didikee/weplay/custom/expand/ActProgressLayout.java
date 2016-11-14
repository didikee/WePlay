package com.didikee.weplay.custom.expand;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.didikee.uilibs.utils.DisplayUtil;
import com.didikee.weplay.R;
import com.didikee.weplay.animations.SimpleExpandAnimation;

/**
 * Created by didik on 2016/11/12.
 */

public class ActProgressLayout extends BaseExpandLayout {

    private ProgressBar mProgressBar;
    private View content;

    public ActProgressLayout(Context context) {
        this(context,null);
    }

    public ActProgressLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ActProgressLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        startFlow(context);
    }

    private void startFlow(Context context) {
        content = LayoutInflater.from(context).inflate(R.layout.item_progress_dialog, null);
        mProgressBar = ((ProgressBar) content.findViewById(R.id.progressBar));
        this.addView(content);
        ViewGroup.LayoutParams layoutParams = content.getLayoutParams();
        layoutParams.height=0;
        content.setLayoutParams(layoutParams);
    }

    @Override
    public void expand() {
        int height = DisplayUtil.dp2px(getContext(), 36);
        SimpleExpandAnimation simpleExpandAnimation=new SimpleExpandAnimation(0,height);
        Animator[] animators = simpleExpandAnimation.getAnimators(content);
        Animator animator = animators[0];
        if (animator!=null){
            animator.setDuration(618);
            animator.start();
        }
    }

    public void big(){
        ViewGroup.LayoutParams layoutParams = content.getLayoutParams();
        layoutParams.height=300;
        content.setLayoutParams(layoutParams);
    }
    public void updateProgress(int progress){
        progress = progress >100 ? 100 :progress <0 ? 0 :progress;
        mProgressBar.setProgress(progress);
    }

    @Override
    public void shrink() {

    }

    public void setOnFinishListener(){

    }
}
