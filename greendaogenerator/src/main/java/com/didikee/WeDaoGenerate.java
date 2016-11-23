package com.didikee;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class WeDaoGenerate {
    public static void main(String[] args) throws Exception {
        int version=1;
        String defaultPackage="green.didikee.model";
        String defaultPackageDao="green.didikee.dao";
        String outDir="We/src/main/java-gen";

        Schema schema = new Schema(version, defaultPackage);
      schema.setDefaultJavaPackageDao(defaultPackageDao);

        //TODO add java model
        addPerson(schema);

        new DaoGenerator().generateAll(schema, outDir);
    }

    /**
     * @param schema
     */
    private static void addPerson(Schema schema){
        Entity person = schema.addEntity("Person");
        person.addIdProperty();
        /*level 1*/
        person.addStringProperty("name").notNull();
        person.addIntProperty("sex");
        person.addIntProperty("age");
        /*level 2*/
        person.addStringProperty("nickName");//别名
        person.addLongProperty("firstDate");
        person.addLongProperty("updateDate");
        person.addStringProperty("phoneNumbers");//多个
        person.addStringProperty("emails");
        person.addLongProperty("noteCount");
        person.addLongProperty("likeCount");
        person.addLongProperty("badCount");
        person.addLongProperty("phoneCount");
        person.addLongProperty("smsCount");
        person.addLongProperty("sexCount");
        person.addIntProperty("star");//max 5;
        person.addStringProperty("desc");
        person.addStringProperty("subDesc");
        person.addLongProperty("birthday");//生日
        person.addIntProperty("constellation");//星座
        person.addStringProperty("tag");
        /*level 3*/
        person.addStringProperty("contactID");
    }
}
