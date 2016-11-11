package com.didikee.weplay.base;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.didikee.uilibs.views.ImageTextView;
import com.didikee.weplay.R;

/**
 * Created by didik on 2016/10/12.
 */

public abstract class UBaseActivity extends Activity implements View.OnClickListener{
    private View mTitleView;
    private View mContentView;

    private CharSequence mTitleText;

    private int TITLE_ITEM_WIDTH;
    //    private final int TITLE_HEIGHT=DisplayUtil.dp2px(this,40);
    private LinearLayout mBaseContent; //rootContainer


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
//        LinearLayout mBaseContent = (LinearLayout) LayoutInflater.from(this).inflate(R.layout
//                .layout_act_base, null);
        mBaseContent = new LinearLayout(this);
        mBaseContent.setOrientation(LinearLayout.VERTICAL);
        View fromLayout = LayoutInflater.from(this).inflate(layoutResID, null);
        FrameLayout defaultTitleView = createDefaultTitleView();
        mBaseContent.addView(defaultTitleView,0,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,TITLE_ITEM_WIDTH));
        mBaseContent.addView(fromLayout,1);
        super.setContentView(mBaseContent);
    }

    /**
     * 设置自定义的customTitleView
     * @param customTitleView your title view
     */
    protected void setCustomTitleView(View customTitleView) {
        if (mBaseContent.getChildCount()==2){
            mBaseContent.removeViewAt(0);
            mBaseContent.addView(customTitleView,0,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,TITLE_ITEM_WIDTH));
        }else {

        }
    }

    protected void setCustomTitleView(int customTitleViewId) {
        View customTitleView = LayoutInflater.from(this).inflate(customTitleViewId, null);
        setCustomTitleView(customTitleView);
    }


    private FrameLayout createDefaultTitleView(){
        FrameLayout titleContainer=new FrameLayout(this);
//        FrameLayout.LayoutParams fParams=getFrameLayoutParam(FrameLayout.LayoutParams.MATCH_PARENT,TITLE_HEIGHT);
//        titleContainer.setLayoutParams(fParams);
        titleContainer.setBackgroundColor(Color.WHITE);

        ImageTextView left=new ImageTextView(this);
        left.setImageResource(R.drawable.ic_left_orange_arrow);
        left.setId(R.id.LEFT);
        left.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        left.setText("左");
        left.setBackground(getResources().getDrawable(R.drawable.md_ripple_unbound_gray));
        FrameLayout.LayoutParams leftParams = getFrameLayoutParam(TITLE_ITEM_WIDTH,
                FrameLayout.LayoutParams.MATCH_PARENT, Gravity.LEFT);
        titleContainer.addView(left,leftParams);

        ImageTextView right=new ImageTextView(this);
//        left.setImageResource(R.drawable.ic_menu_back);
        right.setId(R.id.right);
        right.setText("右");
        right.setBackground(getResources().getDrawable(R.drawable.md_ripple_unbound_gray));
        FrameLayout.LayoutParams rightParams = getFrameLayoutParam(TITLE_ITEM_WIDTH,
                FrameLayout.LayoutParams.MATCH_PARENT, Gravity.RIGHT);
        titleContainer.addView(right,rightParams);

        TextView middleText=new TextView(this);
        middleText.setTag("middle");
        middleText.setId(R.id.CENTER);
        FrameLayout.LayoutParams middleParams = getFrameLayoutParam(FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        mTitleText=setDefaultTitleText();
        middleText.setText(mTitleText);
        middleText.setTextSize(18);
        middleText.setTextColor(Color.BLACK);
        titleContainer.addView(middleText,middleParams);

        //底部下划线
        View line=new View(this);
        FrameLayout.LayoutParams lineParams = getFrameLayoutParam(FrameLayout.LayoutParams.MATCH_PARENT,
                1, Gravity.BOTTOM);
        line.setBackgroundColor(Color.GRAY);
        titleContainer.addView(line,lineParams);

        left.setOnClickListener(this);
        right.setOnClickListener(this);
        return titleContainer;
    }

    private FrameLayout.LayoutParams getFrameLayoutParam(int width, int height, int gravity){
        FrameLayout.LayoutParams fParams=new FrameLayout.LayoutParams(width, height,gravity);
        return fParams;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.LEFT){
            onTitleLeftClick(v);
        }else if (id==R.id.RIGHT){
            onTitleRightClick(v);
        }
    }

    protected void onTitleLeftClick(View v){
        onBackPressed();
    }
    protected void onTitleRightClick(View v){
    }

    protected void onTitleLeftClick(View v,int index){
        if (index==0){
            onBackPressed();
        }
    }

    /**
     * 右边被点击
     * <p>从右边往左数</p>
     * @param v view
     * @param index location
     */
    protected void onTitleRightClick(View v,int index){

    }

    protected CharSequence setDefaultTitleText(){
        return "标题";
    }



    /**
     * 隐藏标题
     */
    protected void hideTitleView(){
        if (mBaseContent.getChildCount()==2){
            mBaseContent.removeViewAt(0);
        }
    }

    protected void setDefaultMiddleTextGravity(){
        FrameLayout mDefaultTitleGroup = (FrameLayout) mBaseContent.getChildAt(0);
        TextView tvMiddle= (TextView) mDefaultTitleGroup.findViewById(R.id.CENTER);
        ViewGroup.LayoutParams layoutParams = tvMiddle.getLayoutParams();
//        layoutParams.
    }
}
