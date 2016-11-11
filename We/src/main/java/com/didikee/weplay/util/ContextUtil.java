package com.didikee.weplay.util;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

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


}
