package com.didikee.weplay.custom.bottomNavigationView;

import android.support.design.internal.*;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.ViewGroup;

/**
 * Created by didik on 2016/11/21.
 */

public class BottomNavigationAnimationHelperIcs extends BottomNavigationAnimationHelperBase {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;

    private final TransitionSet mSet;

    BottomNavigationAnimationHelperIcs() {
        mSet = new AutoTransition();
        mSet.setOrdering(TransitionSet.ORDERING_TOGETHER);
        mSet.setDuration(ACTIVE_ANIMATION_DURATION_MS);
        mSet.setInterpolator(new FastOutSlowInInterpolator());
        TextScale textScale = new TextScale();
        mSet.addTransition(textScale);
    }

    public void beginDelayedTransition(ViewGroup view) {
        TransitionManager.beginDelayedTransition(view, mSet);
    }
}
