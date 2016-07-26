package com.gd.zhenghy.myviewdemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zhenghy on 2016/7/26.
 */
public class Topbar extends RelativeLayout {
    private Button leftButton,rightButton;
    private TextView tvTitle;
    
    private int leftColor;
    private Drawable leftBackground;
    private String leftText;
    
    private int rightColor;
    private Drawable rightBackground;
    private String rightText;

    private float titleTextsize;
    private int titleTextColor;
    private String title;
    private TopbarClickListener listener;
    public interface TopbarClickListener{
        void leftclick();
       void  rightClick();
    }
    public void setonTopbarClickListener(TopbarClickListener topbarClickListener){
        this.listener=topbarClickListener;
    }

    private LayoutParams leftParams,rightParams,titleParams;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public Topbar(final Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Topbar);
        leftColor=typedArray.getColor(R.styleable.Topbar_leftTextColor,0);
        leftBackground=typedArray.getDrawable(R.styleable.Topbar_leftBackground);
        leftText=typedArray.getString(R.styleable.Topbar_leftText);

        rightColor=typedArray.getColor(R.styleable.Topbar_rightTextColor,0);
        rightBackground=typedArray.getDrawable(R.styleable.Topbar_rightBackground);
        rightText=typedArray.getString(R.styleable.Topbar_rightText);

        titleTextsize=typedArray.getDimension(R.styleable.Topbar_titleTextSize,0);
        titleTextColor=typedArray.getColor(R.styleable.Topbar_titleTextColor,0);
        title=typedArray.getString(R.styleable.Topbar_title);
        
        typedArray.recycle();
        
        leftButton=new Button(context);
        rightButton=new Button(context);
        tvTitle=new TextView(context);
        
        leftButton.setTextColor(leftColor);
        leftButton.setBackground(leftBackground);
        leftButton.setText(leftText);
        
        rightButton.setText(rightText);
        rightButton.setTextColor(rightColor);
        rightButton.setBackground(rightBackground);
        
        tvTitle.setText(title);
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(titleTextsize);
        tvTitle.setGravity(Gravity.CENTER);
        
        setBackgroundColor(0xfff59563);
        
        leftParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        addView(leftButton,leftParams);

        rightParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
       rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(rightButton,rightParams);


        titleParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(tvTitle,titleParams);


        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
               listener.leftclick();
            }
        });
        rightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.rightClick();
            }
        });

    }
  public  void setLeftVisible(boolean flag){
        if (flag){
            leftButton.setVisibility(VISIBLE);
        }else{
            leftButton.setVisibility(GONE);
        }
    }
}
