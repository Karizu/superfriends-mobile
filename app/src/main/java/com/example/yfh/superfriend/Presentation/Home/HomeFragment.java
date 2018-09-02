package com.example.yfh.superfriend.Presentation.Home;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.yfh.superfriend.FragmentSlider;
import com.example.yfh.superfriend.Model.ArticleModel;
import com.example.yfh.superfriend.R;
import com.example.yfh.superfriend.Service.AdapterListMenuHome;
import com.example.yfh.superfriend.SliderIndicator;
import com.example.yfh.superfriend.SliderPagerAdapter;
import com.example.yfh.superfriend.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private SliderView sliderView;
    private LinearLayout linearLayout;
    private SliderIndicator sliderIndicator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sliderView = getView().findViewById(R.id.slider_view);
        linearLayout = getView().findViewById(R.id.pages_container);
        populateImageSlider();
        LinearLayout ll = getView().findViewById(R.id.popup_event);
        final View homePopupView = getLayoutInflater().inflate(R.layout.home_popup, null);
        ll.addView(homePopupView);
        ImageView closeImageView = getView().findViewById(R.id.close_image);
        closeImageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                homePopupView.setVisibility(View.GONE);
                return false;
            }
        });
        new LoadDataRecyclerView().execute("");
    }

    private class LoadDataRecyclerView extends AsyncTask<String, Void, List<ArticleModel>> {
        protected List<ArticleModel> doInBackground(String... urls){
            List<ArticleModel> articleModels = new ArrayList<>();
            populateData(articleModels);

            return articleModels;
        }
        protected void onPostExecute(List<ArticleModel> articleModels){
            Context activity = getActivity();
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity,
                    LinearLayout.VERTICAL,
                    false);
            RecyclerView recyclerView = getView().findViewById(R.id.home_recycle_view);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView.Adapter adapter = new AdapterListMenuHome(articleModels, activity);
            recyclerView.setAdapter(adapter);
        }
    }

    // For testing purpose
    private void populateData(List<ArticleModel> articleModels){
        articleModels.add(new ArticleModel("1",
                "",
                "Article 1",
                "Artikel ini bercerita tentang artikel yang dibuat oleh sang pembuat artikel kenamaan di rumahnya yang berada nan jauh disana",
                getFragmentManager()));
        articleModels.add(new ArticleModel("2",
                "",
                "Penulis Artikel",
                "Penulis artikel adalah penulis yang menggunakan sebuat tools, bisa berupa komputer, mesin tik, pena, dan lainnya. Penulis artikel perlu belajar lebih banyak agar bisa menghidupi pikirannya. Karena pikiran yang penuh pengetahuan itu adalah pikiran yang diperlukan oleh penulis artikel.",
                getFragmentManager()));
        articleModels.add(new ArticleModel("3",
                "",
                "Sejarah Artikel",
                "Penulis artikel adalah penulis yang menggunakan sebuat tools, bisa berupa komputer, mesin tik, pena, dan lainnya.",
                getFragmentManager()));
        articleModels.add(new ArticleModel("4",
                "",
                "Berita Terkini",
                "Penulis artikel adalah penulis yang menggunakan sebuat tools, bisa berupa komputer, mesin tik, pena, dan lainnya.",
                getFragmentManager()));
    }

    private void populateImageSlider(){
//        sliderView.setDurationScroll(800);
        Log.i("Populate Image", "populate image");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/zYFQM9G5j9cRsMNMuZAX64nmUMf.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/rXBB8F6XpHAwci2dihBCcixIHrK.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/biN2sqExViEh8IYSJrXlNKjpjxx.jpg"));
        fragments.add(FragmentSlider.newInstance("https://image.tmdb.org/t/p/w250_and_h141_bestv2/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(adapter);

        sliderIndicator = new SliderIndicator(getContext(), linearLayout, sliderView, R.drawable.ic_circle);
        sliderIndicator.setPageCount(fragments.size());
        sliderIndicator.show();
    }
}
