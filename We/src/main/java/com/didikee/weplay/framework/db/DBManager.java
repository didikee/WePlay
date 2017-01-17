package com.didikee.weplay.framework.db;

import android.content.Context;

import com.didikee.weplay.framework.db.helpers.NoteDaoHelper;
import com.didikee.weplay.framework.db.helpers.PersonDaoHelper;
import com.didikee.weplay.framework.greendao3.UpgradeOpenHelper;
import com.didikee.weplay.greendao.gen.DaoMaster;
import com.didikee.weplay.greendao.gen.DaoSession;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by didik on 2016/11/24.
 */

public class DBManager {
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    private static Context mContext;
    private static final String DB_NAME ="we.db";

    public static void init(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        mContext = context.getApplicationContext();
    }
    /**
     * 是否开启日志
     * @param enable 是否开启
     */
    public static void enableQueryBuilderLog(boolean enable){
        QueryBuilder.LOG_SQL = enable;
        QueryBuilder.LOG_VALUES = enable;
    }

    private static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            //此处不可用 DaoMaster.DevOpenHelper, 那是开发辅助类，我们要自定义一个，方便升级
            DaoMaster.OpenHelper helper = new UpgradeOpenHelper(mContext, DB_NAME);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    private static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    private static PersonDaoHelper personDaoHelper;
    public static PersonDaoHelper getPersonDaoHelper() {
        if (personDaoHelper == null) {
            personDaoHelper = new PersonDaoHelper(getDaoSession().getPersonDao());
        }
        return personDaoHelper;
    }

    private static NoteDaoHelper noteDaoHelper;
    public static NoteDaoHelper getNoteDaoHelper() {
        if (noteDaoHelper == null) {
            noteDaoHelper = new NoteDaoHelper(getDaoSession().getNoteDao());
        }
        return noteDaoHelper;
    }

}
