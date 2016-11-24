package com.didikee.weplay.ui.views.iview;

import android.view.View;

/**
 * Created by didik on 2016/11/24.
 */

public interface OnFavoriteHumanClickListener {
    void onNoteClick(View view,Long number);
    void onLikeClick(View view,Long number);
    void onSadClick(View view,Long number);
}
