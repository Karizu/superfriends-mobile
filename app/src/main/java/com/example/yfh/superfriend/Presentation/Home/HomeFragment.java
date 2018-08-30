package com.example.yfh.superfriend.Presentation.Home;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.yfh.superfriend.Model.ArticleModel;
import com.example.yfh.superfriend.Presentation.Artikel.ArtikelFragment;
import com.example.yfh.superfriend.R;
import com.example.yfh.superfriend.Service.AdapterListMenuArticle;
import com.example.yfh.superfriend.Service.AdapterListMenuHome;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
}
