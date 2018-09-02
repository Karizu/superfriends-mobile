package com.example.yfh.superfriend;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class SliderIndicator implements ViewPager.OnPageChangeListener {
    private Context context;
    private LinearLayout container;
    private @DrawableRes int drawable;
    private int spacing;
    private int size;
    private ViewPager viewPager;
    private int pageCount;
    private int initialPage = 0;

    private int defaultSizeInDp = 12;
    private int defaultSpacingInDp = 12;

    public SliderIndicator(@NonNull Context context,
                           @NonNull LinearLayout container,
                           @NonNull ViewPager viewPager,
                           @DrawableRes int drawable){
        if (context == null){
            throw new IllegalArgumentException("context cannot be null");
        } else if (container == null){
            throw new IllegalArgumentException("container cannot be null");
        } else if (viewPager == null){
            throw new IllegalArgumentException("viewPager cannot be null");
        } else if (viewPager.getAdapter() == null){
            throw new IllegalArgumentException("ViewPager does not have an adapter set on it");
        }
        this.context = context;
        this.container = container;
        this.viewPager = viewPager;
        this.drawable = drawable;
    }

    public void setPageCount(int pageCount){
        this.pageCount = pageCount;
    }

    public void setInitialPage(int page){
        initialPage = page;
    }

    public void setDrawable(@DrawableRes int drawable){
        this.drawable = drawable;
    }

    public void setSpacingRes(@DimenRes int spacingRes){
        spacing = spacingRes;
    }

    public void setSize(@DimenRes int dimenRes){
        size = dimenRes;
    }

    public void show(){
        initIndicators();
        setIndicatorAsSelected(initialPage);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                viewPager.setCurrentItem(1);
            }
        }, 2500);
    }

    private void initIndicators(){
        if (container == null || pageCount <= 0){
            return;
        }
        Log.i("Init Indicators", "Call init indicator");
        viewPager.addOnPageChangeListener(this);
        Resources res = context.getResources();
        container.removeAllViews();
        for (int i = 0; i < pageCount; i++){
            View view = new View(context);
            int dimen = size != 0 ? res.getDimensionPixelSize(size) : ((int) res.getDisplayMetrics().density * defaultSizeInDp);
            int margin = spacing != 0 ? res.getDimensionPixelSize(spacing) : ((int) res.getDisplayMetrics().density * defaultSpacingInDp);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimen, dimen);
            layoutParams.setMargins(i == 0 ? 0 : margin, 0, 0, 0);
            view.setLayoutParams(layoutParams);
            view.setBackground(context.getResources().getDrawable(drawable));
            view.setSelected(i == 0);
            container.addView(view);
        }
    }

    private void setIndicatorAsSelected(int index){
        Log.i("setIndicatorAsSelected", "Call init indicator");
        if (container == null){
            return;
        }

        for (int i = 0; i < container.getChildCount(); i++){
            View view = container.getChildAt(i);
            view.setSelected(i == index);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels){
    }

    @Override
    public void onPageSelected(int position){
        int index = position % pageCount;
        setIndicatorAsSelected(index);
        Log.i("Slide Indicator", "position: " + position + "; Index:" + index);
        final int moveTo = (position + 1) % pageCount;
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
//                    viewPager.setCurrentItem(moveTo);
                }
            }, 2500);
        } catch (Exception ex){

        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        Log.i("Scroll State Changed", "Scroll State Changed " + state);
    }

    public void cleanUp(){
        viewPager.clearOnPageChangeListeners();
    }
}
