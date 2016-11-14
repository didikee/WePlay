package com.didikee.weplay.interf;

/**
 * Created by didik on 2016/11/12.
 */

public interface Statement {
    public static final int PREPARE=0x0;
    public static final int START=0x1;
    public static final int WORK=0x2;
    public static final int FINISH=0x3;
    public static final int SUCCESS=0x4;
    public static final int FAILURE=0x5;
    public static final int CANCEL=0x6;
    public static final int REPEAT=0x7;
}
