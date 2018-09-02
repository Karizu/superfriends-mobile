package com.example.yfh.superfriend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FragmentSlider extends Fragment {
    private static final String ARG_PARAM1 = "params";

    private String imageUrls;

    public FragmentSlider(){

    }

    public static FragmentSlider newInstance(String params){
        FragmentSlider  fragmentSlider = new FragmentSlider();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, params);
        fragmentSlider.setArguments(bundle);
        return fragmentSlider;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle bundle){
        imageUrls = getArguments().getString(ARG_PARAM1);
        View view = inflater.inflate(R.layout.fragment_slider_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.img);
        Glide.with(getActivity()).load(imageUrls).into(imageView);
        return view;
    }
}
