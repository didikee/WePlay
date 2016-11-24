package com.didikee.weplay.framework.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import green.didikee.dao.DaoMaster;
import green.didikee.dao.DaoSession;
import green.didikee.dao.PersonDao;
import green.didikee.model.Person;

/**
 * Created by didik on 2016/11/24.
 */

public class DBManager {
    private static DBManager instance;

    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private PersonDao mPersonDao;


    public static synchronized DBManager getInstance(Context context) {
        if (instance == null)
            instance = new DBManager(context);
        return instance;
    }

    private DBManager(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, "we-db", null);
        db = helper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        mPersonDao = mDaoSession.getPersonDao();
        mPersonDao.getDatabase();
    }

    public void insertPerson(Person person) {
        mPersonDao.insert(person);
    }



    public void insertPersons(List<Person> list) {
        for (Person s : list) {
            mPersonDao.insert(s);
        }
    }

    /**
     * 获取所有的student表中数据
     *
     * @return
     */
    public List<Person> getAllPersons() {
        return mPersonDao.loadAll();
    }


    public void deletePerson(Person person){
        mPersonDao.delete(person);
    }

    public void deleteAllPersons(){
        mPersonDao.deleteAll();
    }

    public void closeDb() {
        if (db.isOpen())
            db.close();
    }
}
