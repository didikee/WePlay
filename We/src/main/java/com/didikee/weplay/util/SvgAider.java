package com.didikee.weplay.util;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

/**
 * Created by didik on 2016/11/23.
 */

public final class SvgAider {
    /**
     * sample doc
     * EditText editText1 = (EditText) findViewById(R.id.edit_1);
     * final Drawable originalDrawable = editText1.getBackground();
     * final Drawable wrappedDrawable = tintDrawable(originalDrawable, ColorStateList.valueOf(Color.RED));
     * editText1.setBackgroundDrawable(wrappedDrawable);
     *
     * EditText editText2 = (EditText) findViewById(R.id.edit_2);
     * editText2.setBackgroundDrawable(tintDrawable(editText2.getBackground(),
     * ColorStateList.valueOf(Color.parseColor("#03A9F4"))));
     *
     *
     *
     * but,you could use ColorStateList to performance this drawable
     * like this,it can be better than use a single color for have some statement.
     * step 1:
     *  define : res/color/edittext_tint_colors.xml
     *  content:
     * <selector xmlns:android="http://schemas.android.com/apk/res/android">
     * <item android:color="@color/red" android:state_focused="true" />
     * <item android:color="@color/gray" />
     * </selector>
     * step 2:
     * editText2.setBackgroundDrawable(tintDrawable(editText2.getBackground(),getResources().getColorStateList(R.color.edittext_tint_colors)));
     *
     *
     * finally: if you have double icon have the same color .you should call mutate();
     * like this:
     * ImageView imageView = (ImageView) findViewById(R.id.image_1);
     * final Drawable originalBitmapDrawable = getResources().getDrawable(R.drawable.icon).mutate();
     * imageView.setImageDrawable(tintDrawable(originalBitmapDrawable, ColorStateList.valueOf(Color.MAGENTA)));
     * @param drawable
     * @param colors
     * @return
     */
    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }
    public static Drawable tintDrawable(Drawable drawable, int color) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, ColorStateList.valueOf(color));
        return wrappedDrawable;
    }
}
