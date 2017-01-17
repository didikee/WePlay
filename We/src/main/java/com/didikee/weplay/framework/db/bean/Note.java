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
public class Note {
    @Id(autoincrement = true)
    private Long id;
    private String headline;
    private String subHead;
    private String content;
    private long crateTime;
    private long updateTime;
    private boolean hide;
    private int level;
    private String sort;
    private String tag;
    public String getTag() {
        return this.tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getSort() {
        return this.sort;
    }
    public void setSort(String sort) {
        this.sort = sort;
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
    public long getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
    public long getCrateTime() {
        return this.crateTime;
    }
    public void setCrateTime(long crateTime) {
        this.crateTime = crateTime;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getSubHead() {
        return this.subHead;
    }
    public void setSubHead(String subHead) {
        this.subHead = subHead;
    }
    public String getHeadline() {
        return this.headline;
    }
    public void setHeadline(String headline) {
        this.headline = headline;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 489126909)
    public Note(Long id, String headline, String subHead, String content,
            long crateTime, long updateTime, boolean hide, int level, String sort,
            String tag) {
        this.id = id;
        this.headline = headline;
        this.subHead = subHead;
        this.content = content;
        this.crateTime = crateTime;
        this.updateTime = updateTime;
        this.hide = hide;
        this.level = level;
        this.sort = sort;
        this.tag = tag;
    }
    @Generated(hash = 1272611929)
    public Note() {
    }

}
