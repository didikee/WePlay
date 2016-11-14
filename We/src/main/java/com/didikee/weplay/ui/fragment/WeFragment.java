package com.didikee.weplay.ui.fragment;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseFragment;
import com.didikee.weplay.custom.expand.ActProgressLayout;
import com.didikee.weplay.custom.utils.AlertDialogButtonHandler;
import com.didikee.weplay.framework.AsyncContactHandler;
import com.didikee.weplay.framework.contact.SimpleContact;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by didik on 2016/11/12.
 */

public class WeFragment extends BaseFragment {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected int setLayoutResId() {
        return R.layout.fragment_one_note;
    }

    @Override
    protected void initView(View content) {

    }

    @Override
    protected void startFlow() {
//        initContact();
        final ActProgressLayout actProgressLayout = new ActProgressLayout(getActivity());

        AlertDialog mdDialog = new AlertDialog.Builder(getActivity())
                .setTitle("测试")
                .setMessage("-------------------------------------")
                .setView(actProgressLayout)
                .setPositiveButton("允许", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        actProgressLayout.expand();
//                        actProgressLayout.big();
                        Log.d(TAG, "onClick: 1");
                    }
                })
                .setNegativeButton("拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Log.d(TAG, "onClick: 2");
                    }
                })
                .setCancelable(false).create();

        try {

            Field field = mdDialog.getClass().getDeclaredField("mAlert");
            field.setAccessible(true);
            //   获得mAlert变量的值
            Object obj = field.get(mdDialog);
            field = obj.getClass().getDeclaredField("mHandler");
            field.setAccessible(true);
            //   修改mHandler变量的值，使用新的ButtonHandler类
            field.set(obj, new AlertDialogButtonHandler(mdDialog));
        } catch (Exception e) {
            Log.d(TAG, "startFlow: error");
        }
        mdDialog.show();
    }

    MaterialDialog progressDialog;

    private void initContact() {
        final AsyncTask<Void, Integer, List<SimpleContact>> a = new AsyncContactHandler(getActivity()) {
            @Override
            protected List<SimpleContact> doInBackground(Void... params) {
                return super.doInBackground(params);
            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog.show();
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                Log.d(TAG, "onProgressUpdate: " + values[0]);
                progressDialog.setProgress(values[0]);
            }

            @Override
            protected void onPostExecute(List<SimpleContact> simpleContacts) {
                super.onPostExecute(simpleContacts);
                Log.d(TAG, "onPostExecute: " + simpleContacts.size());
                progressDialog.setProgress(50);
                progressDialog.dismiss();
            }
        };
//        a.execute();
//        .progress(false,15,false)
//        progressDialog =new MaterialDialog.Builder(getActivity())
//                .title("尝试读取手机联系人")
//                .content("初次使用会显示本次会话")
//                .positiveText("允许")
//                .negativeText("拒绝")
//                .onPositive(new MaterialDialog.SingleButtonCallback() {
//                    @Override
//                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                        if (which==DialogAction.POSITIVE){
//                            progressDialog.setTitle("正在读取通讯录");
//                            progressDialog.setContent("联系人数量： ");
//                            progressDialog.
////                            a.execute();
//                        }
//                    }
//                })
//                .onNegative(new MaterialDialog.SingleButtonCallback() {
//                    @Override
//                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
//                        if (which==DialogAction.NEGATIVE){
//                            progressDialog.dismiss();
//                        }
//                    }
//                })
//                .show();


    }
}
