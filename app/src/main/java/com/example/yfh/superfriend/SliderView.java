package com.example.yfh.superfriend;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

import java.lang.reflect.Field;

public class SliderView extends ViewPager {

    public static final int DEFAULT_DURATION = 800;
    public static final int SLIDE_MODE_SCROLL_DURATION = 5000;

    public SliderView(Context context){
        super(context);
        Log.i("Slider View 1", "");
        init();
    }

    public SliderView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        Log.i("Slider View 1", "");
        init();
    }

    private void init(){
//        setDurationScroll(DEFAULT_DURATION);
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
    }

//    public void setDurationScroll(int milliSecond){
//        try{
//            Class<?> viewPager = ViewPager.class;
//            Field scroller = viewPager.getDeclaredField("mScroller");
//            scroller.setAccessible(true);
//            scroller.set(this, new OwnScroller(getContext(), milliSecond));
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//    }

//    public class OwnScroller extends Scroller{
//        private  int durationScrollInMilliSecond = 1;
//
//        public OwnScroller(Context context, int durationScroll){
//            super(context, new DecelerateInterpolator());
//            Log.i("Start Scroll", "");
//            this.durationScrollInMilliSecond = durationScroll;
//        }
//
//        @Override
//        public void startScroll(int startX, int startY, int dx, int dy, int duration){
//            Log.i("Start Scroll", "" + startX + " " + startY + " " + duration);
//            Log.i("Start Scroll", "" + dx + " " + dy + " " + duration);
//            super.startScroll(startX, startY, dx, dy, durationScrollInMilliSecond);
//        }
//    }
}
