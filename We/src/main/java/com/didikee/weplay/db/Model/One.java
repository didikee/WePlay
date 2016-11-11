package com.didikee.weplay.db.Model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by didik on 2016/10/11.
 * the base model of human
 */
@Table( name = "Ones")
public class One extends Model {

    /*
    * name 姓名
    * sex 性别
    *
    *
    * */

    @Column(name = "Name")
    public String name;

    @Column(name = "Sex")
    public int sex;

    @Column(name = "Age")
    public int age;

    @Column(name = "NickName")
    public String nickName;



}
