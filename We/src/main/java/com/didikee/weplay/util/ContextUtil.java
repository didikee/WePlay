package com.didikee.weplay.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by didik on 2016/11/8.
 */

public class ContextUtil {
    private static final String TAG="ContextUtil";

    public static void startActivity(Activity activity, Class clz ,Intent intent){
        if (activity==null || clz ==null){
            Log.e(TAG,"startActivity params is null .");
            return;
        }
        if (intent==null){
            intent =new Intent(activity,clz);
        }
        activity.startActivity(intent);
    }
    public static void startActivity(Activity activity,Class clz){
        startActivity(activity,clz,null);
    }

    /**
     * 获取设备的宽高
     * @param context context
     * @return pair(width,height)
     */
    public static Pair<Integer,Integer> getRealWidthHeight(@NonNull Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = wm.getDefaultDisplay();
        Point sizePoint=new Point();
        defaultDisplay.getRealSize(sizePoint);
        return new Pair<>(sizePoint.x,sizePoint.y);
    }


}
