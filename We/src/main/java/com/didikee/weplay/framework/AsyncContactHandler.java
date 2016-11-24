package com.didikee.weplay.framework;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.util.Log;

import com.didikee.weplay.base.APPCode;
import com.didikee.weplay.framework.bean.contact.SimpleContact;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by didik on 2016/11/12.
 * 获取通讯录联系人
 * {@link com.didikee.weplay.framework.bean.contact.SimpleContact}
 */

public abstract class AsyncContactHandler extends AsyncTask<Void,Integer,List<SimpleContact>>{

    private final String TAG=getClass().getSimpleName();
    //获取联系人信息的Uri
    private final Uri uri = ContactsContract.Contacts.CONTENT_URI;
    private final Context context;

    /**
     * 获取联系人的ID
     * @param cursor db
     * @return ContactId
     */
    private String getContactId(Cursor cursor){
        return cursor == null ? "" :cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
    }

    /**
     * 获取联系人的姓名
     * @param cursor db
     * @return ContactName
     */
    private String getContactName(Cursor cursor){
        return cursor == null ? "" :cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
    }

    /**
     * 获取联系人电话号码
     * @param contentResolver contentResolver
     * @param contactId contactID
     * @return phone number
     */
    private List<String> getContactPhoneNum(ContentResolver contentResolver,String contactId){
        List<String> phoneNumber ;
        if (contentResolver == null)return null;
        phoneNumber=new ArrayList<>();
        //查询电话类型的数据操作
        Cursor phones = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId,
                null, null);
        if (phones!=null){
            while (phones.moveToNext()) {
                String indexPhoneNum = phones.getString(phones.getColumnIndex(
                        ContactsContract.CommonDataKinds.Phone.NUMBER));
                phoneNumber.add(indexPhoneNum);
            }
            phones.close();
        }
        return phoneNumber;
    }

    /**
     * 获取联系人邮件地址
     * @param contentResolver contentResolver
     * @param contactId contactID
     * @return email address
     */
    private List<String> getContactEmail(ContentResolver contentResolver,String contactId){
        List<String> emailList ;
        if (contentResolver == null)return null;
        emailList=new ArrayList<>();
        Cursor emails = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI,
                null,
                ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = " + contactId,
                null, null);
        if (emails!=null){
            while (emails.moveToNext()) {
                String emailAddress = emails.getString(emails.getColumnIndex(
                        ContactsContract.CommonDataKinds.Email.DATA));
                //添加Email的信息
                emailList.add(emailAddress);
            }
            emails.close();
        }
        return emailList;
    }

    private List<SimpleContact> queryAllContact() throws Throwable{
        if (context == null) return null;
        List<SimpleContact> allContact =null;
        //获取ContentResolver
        ContentResolver contentResolver = context.getContentResolver();
        //查询数据，返回Cursor
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        int size=0;
        publishProgress(size);
        if (cursor!=null){
            allContact =new ArrayList<>();
            while (cursor.moveToNext()) {
                SimpleContact single=new SimpleContact();
                String contactId = getContactId(cursor);
                String name = getContactName(cursor);
                //构造联系人信息
                single.setContactID(contactId);
                single.setName(name);
                single.setPhone(getContactPhoneNum(contentResolver,contactId));
                //查询Email类型的数据操作
                single.setEmail(getContactEmail(contentResolver,contactId));
                allContact.add(single);
                size++;
                publishProgress(size);
            }
            cursor.close();
        }else {
            Log.d(TAG, "getAllContact: is null");
        }
        return allContact;
    }


    @Override
    protected List<SimpleContact> doInBackground(Void... params) {
        List<SimpleContact> result=null;
        try {
            result=queryAllContact();
        } catch (Throwable throwable) {
            Log.d(TAG, "doInBackground: found some error!");
        }
        return result;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(APPCode.APP_TAG,"pre to start!");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected void onCancelled(List<SimpleContact> simpleContacts) {
        super.onCancelled(simpleContacts);
    }

    @Override
    protected void onPostExecute(List<SimpleContact> simpleContacts) {
        super.onPostExecute(simpleContacts);
    }

    public AsyncContactHandler(Context context) {
        super();
        this.context=context;
    }
}
