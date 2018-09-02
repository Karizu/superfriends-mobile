package com.example.yfh.superfriend;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SliderPagerAdapter extends FragmentStatePagerAdapter{

    private List<Fragment> fragments;
    private int fragmentSize;

    public SliderPagerAdapter(FragmentManager fragmentManager, List<Fragment> fragments){
        super(fragmentManager);
        this.fragments = fragments;
        fragmentSize = fragments.size();
    }

    @Override
    public Fragment getItem(int position){
        int index = position % fragmentSize;
        Log.i("getItem", "position: " + position + "; Index:" + index);
        return fragments.get(index);
//        return FragmentSlider.newInstance(fragments.get(index).getArguments().getString("params"));
    }

    @Override
    public int getCount(){
        return Integer.MAX_VALUE;
    }
}
