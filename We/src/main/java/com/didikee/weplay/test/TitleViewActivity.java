package com.didikee.weplay.test;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.didikee.weplay.R;
import com.didikee.weplay.base.BaseActivity;

public class TitleViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_view);
        setDefaultLeftViewParams(R.drawable.ic_menu_back,null, ImageView.ScaleType.CENTER_INSIDE);
    }

    @Override
    protected void onTitleLeftClick(View v) {
        super.onTitleLeftClick(v);
    }

    @Override
    protected void onTitleRightClick(View v) {
        super.onTitleRightClick(v);
    }

    @Override
    protected CharSequence setDefaultTitleText() {
        return "我是标题";
    }

//    @Override
//    protected void setDefaultLeftView(ImageTextView itv) {
//        super.setDefaultLeftView(itv);
//        if (itv==null){
//            Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
//        }else {
//            itv.setText("哈哈");
//        }
//    }
}
