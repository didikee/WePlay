package com.didikee.weplay.framework.db.helpers;

import com.didikee.weplay.framework.db.bean.Person;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by didik 
 * Created time 2017/1/16
 * Description: 
 */

public class PersonDaoHelper extends BaseDaoHelper<Person,Long> {
    public PersonDaoHelper(AbstractDao dao) {
        super(dao);
    }
}
