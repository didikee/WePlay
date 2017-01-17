package com.didikee.weplay.framework.db.helpers;

import com.didikee.weplay.framework.db.bean.Note;

import org.greenrobot.greendao.AbstractDao;

/**
 * Created by didik 
 * Created time 2017/1/17
 * Description: 
 */

public class NoteDaoHelper extends BaseDaoHelper<Note,Long> {
    public NoteDaoHelper(AbstractDao dao) {
        super(dao);
    }
}
