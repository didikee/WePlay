package com.didikee.weplay.framework.greendao3;

import android.content.Context;
import android.util.Log;

import com.didikee.weplay.greendao.gen.DaoMaster;
import com.didikee.weplay.greendao.gen.NoteDao;
import com.didikee.weplay.greendao.gen.PersonDao;

import org.greenrobot.greendao.database.Database;

/**
 * Created by didik 
 * Created time 2017/1/16
 * Description: 
 */

public class UpgradeOpenHelper extends DaoMaster.OpenHelper {
    public UpgradeOpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        Log.w("test", "db version update from " + oldVersion + " to " + newVersion);

        switch (oldVersion) {
            case 1:
                //不能先删除表，否则数据都木了
                //PersonDao.dropTable(db, true);
                PersonDao.createTable(db, true);
                NoteDao.createTable(db,true);
                break;
        }
    }
}
