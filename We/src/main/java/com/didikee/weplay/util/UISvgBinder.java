package com.didikee.weplay.util;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by didik on 2016/11/23.
 */

public class UISvgBinder {

    public static void setImageView(ImageView svgImageView, int svgResID,int color, Resources res){
        Drawable drawable = res.getDrawable(svgResID);
        Drawable drawableAider = SvgAider.tintDrawable(drawable, color);
        svgImageView.setImageDrawable(drawableAider);
    }


}
