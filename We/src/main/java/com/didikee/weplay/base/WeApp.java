package com.didikee.weplay.base;

import android.app.Application;
import android.util.Log;

import com.didikee.weplay.framework.db.DBManager;

/**
 * Created by didik on 2016/9/20.
 */
public class WeApp extends Application {
    public static final String TAG="WeApp";

    @Override
    public void onCreate() {
        super.onCreate();

        //activity life control
        ActivityLifeManager.getInstance().init(this);

        //db
        DBManager.init(this);
        DBManager.enableQueryBuilderLog(true);
    }

    @Override
    public void onTerminate() {
       super.onTerminate();
        Log.e(TAG,"onTerminate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.e(TAG,"onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.e(TAG,"onTrimMemory-level: "+level);
        if (level==TRIM_MEMORY_UI_HIDDEN){
            Log.e(TAG,"UI Hidden");
        }
    }

}
