package com.didikee.weplay.base;

import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.didikee.weplay.R;

/**
 * Created by didik on 2016/11/14.
 */

public abstract class SimpleBaseActivity extends IBaseActivity implements View.OnClickListener {

    private final String TAG=getClass().getSimpleName();
    /**
     * @return inner false
     *          out true  默认在最外面
     */
    protected boolean setUMiddleTitleMode(){
        return true;
    }
    private LinearLayout getSideView(int who){
        return (LinearLayout) findViewById(who);
    }

    protected TextView setMiddleTextView(){
        TextView middleTextView =new TextView(this);
        middleTextView.setId(getResources().getInteger(R.integer.CENTER));
        middleTextView.setTextSize(16);
        middleTextView.setTextColor(Color.BLACK);
        middleTextView.setGravity(Gravity.CENTER);
        middleTextView.setEllipsize(TextUtils.TruncateAt.END);
        middleTextView.setLines(1);
        return middleTextView;
    }

    private LinearLayout createSileView(boolean isLeft){
        LinearLayout linearLayout=new LinearLayout(this);
        RelativeLayout.LayoutParams linearLayoutParams=new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        if (isLeft){
            linearLayout.setId(getResources().getInteger(R.integer.LEFT));
            linearLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        }else {
            linearLayout.setId(getResources().getInteger(R.integer.RIGHT));
            linearLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        linearLayout.setGravity(Gravity.CENTER_VERTICAL);
        linearLayout.setLayoutParams(linearLayoutParams);
        return linearLayout;
    }

    @Override
    protected void setULeftTitle(Object... model) {
        if (model==null)return;
        for (int i = 0; i < model.length; i++) {
            Object item = model[i];
            if (item==null)continue;
            LinearLayout left = getSideView(getResources().getInteger(R.integer.LEFT));
            if (item instanceof String){
                left.addView(createTitleText((String) item,i+1),getTitleHeight(),getTitleHeight());
            }else if (item instanceof Integer){
                left.addView(createTitleImage((Integer) item,i+1),getTitleHeight(),getTitleHeight());
            }else {
                Log.e(TAG,"title must be string or image resource id !");
            }
        }
    }

    @Override
    protected void setURightTitle(Object... model) {

    }

    @Override
    protected void onULeftClick(View v, int index) {
        if (index==1){
            onBackPressed();
        }
    }

    @Override
    protected void onURightClick(View v, int index) {

    }

    @Override
    protected View setDefaultTitleView() {
        RelativeLayout titleContainer=new RelativeLayout(this);
        LinearLayout leftView = createSileView(true);
        LinearLayout rightView = createSileView(false);
        TextView middleTextView = setMiddleTextView();
        titleContainer.addView(leftView);
        titleContainer.addView(rightView);
        RelativeLayout.LayoutParams rLayoutParams=new RelativeLayout.LayoutParams(ViewGroup
                .LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        if (!setUMiddleTitleMode()){
            rLayoutParams.addRule(RelativeLayout.RIGHT_OF,getResources().getInteger(R.integer.LEFT));
            rLayoutParams.addRule(RelativeLayout.LEFT_OF,getResources().getInteger(R.integer.RIGHT));
        }
        titleContainer.addView(middleTextView,rLayoutParams);
        return titleContainer;
    }

    private TextView createTitleText(String txt,int index){
        TextView textView=new TextView(this);
        textView.setLines(1);
        textView.setText(TextUtils.isEmpty(txt) ? "    " :txt);
        textView.setTextColor(Color.BLUE);
        textView.setTextSize(16);
        textView.setGravity(Gravity.CENTER);
        textView.setClickable(true);
        textView.setBackgroundResource(setTitleItemBackground());
        textView.setTag("LEFT"+index);
        textView.setOnClickListener(this);
        return textView;
    }
    private ImageView createTitleImage(@DrawableRes int imageResID, int index){
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(imageResID);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setClickable(true);
        imageView.setBackgroundResource(setTitleItemBackground());
        imageView.setTag("LEFT"+index);
        imageView.setOnClickListener(this);
        return imageView;
    }

    @Override
    protected int setTitleItemBackground() {
        return R.drawable.md_ripple_unbound_gray;
    }

    @Override
    public void onClick(View v) {
        String s = v.getTag().toString();
        if (s.startsWith("LEFT")){
            String substring = s.substring(4, s.length());
            int index;
            try {
                index = Integer.valueOf(substring);
            } catch (NumberFormatException e) {
                index=99;
            }
            onULeftClick(v,index);
        }else if (s.startsWith("RIGHT")){
            String substring = s.substring(5, s.length());
            int index ;
            try {
                index = Integer.valueOf(substring);
            } catch (NumberFormatException e) {
                index=99;
            }
            onURightClick(v,index);
        }else {
            Log.d("Test","Onclick error left or right ?");
        }
    }

    @Override
    protected void setUMiddleTitle(CharSequence title, int gravity) {
        TextView middleTextView = (TextView) findViewById(getResources().getInteger(R.integer.CENTER));
        middleTextView.setText(TextUtils.isEmpty(title) ? "" : title);
        if (gravity!=Gravity.LEFT && gravity != Gravity.RIGHT && gravity !=Gravity.CENTER){
            gravity=Gravity.CENTER;
        }
        middleTextView.setGravity(gravity);
    }
    protected void setUMiddleTitle(CharSequence title){
        setUMiddleTitle(title,Gravity.CENTER);
    }
}
