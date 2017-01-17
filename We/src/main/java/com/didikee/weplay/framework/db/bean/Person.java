package com.didikee.weplay.framework.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by didik 
 * Created time 2017/1/16
 * Description: 
 */

@Entity
public class Person {
    @Id(autoincrement = true)
    private Long id;
    private String name;//同步通讯录将以此为辨别
    private int sex;
    private String birthday;
    private String phones;
    private String emails;
    private long like;
    private long hate;
    private String signature;//签名
    private String headIcon;//头像地址

    private long linkPersonId;//id
    private boolean hide;
    private int level;//等级

    public long getLinkPersonId() {
        return this.linkPersonId;
    }

    public void setLinkPersonId(long linkPersonId) {
        this.linkPersonId = linkPersonId;
    }

    public String getHeadIcon() {
        return this.headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public long getHate() {
        return this.hate;
    }

    public void setHate(long hate) {
        this.hate = hate;
    }

    public long getLike() {
        return this.like;
    }

    public void setLike(long like) {
        this.like = like;
    }

    public String getEmails() {
        return this.emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhones() {
        return this.phones;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean getHide() {
        return this.hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 690042044)
    public Person(Long id, String name, int sex, String birthday, String phones,
            String emails, long like, long hate, String signature, String headIcon,
            long linkPersonId, boolean hide, int level) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.phones = phones;
        this.emails = emails;
        this.like = like;
        this.hate = hate;
        this.signature = signature;
        this.headIcon = headIcon;
        this.linkPersonId = linkPersonId;
        this.hide = hide;
        this.level = level;
    }

    @Generated(hash = 1024547259)
    public Person() {
    }


}
