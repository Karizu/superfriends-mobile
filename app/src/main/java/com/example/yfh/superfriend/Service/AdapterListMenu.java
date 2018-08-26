package com.example.yfh.superfriend.Service;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yfh.superfriend.Model.ArticleModel;
import com.example.yfh.superfriend.Presentation.Artikel.ArtikelDetailFragment;
import com.example.yfh.superfriend.R;

import java.util.List;

public class AdapterListMenu extends RecyclerView.Adapter<AdapterListMenu.ViewHolder> {
    private List<ArticleModel> articleModels;
    private Context context;

    public AdapterListMenu(List<ArticleModel> articleModels, Context context){
        this.articleModels = articleModels;
        this.context = context;
    }

    @Override
    public AdapterListMenu.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_card_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterListMenu.ViewHolder holder, int position){
        final ArticleModel articleModel = articleModels.get(position);
        int imageResource = context.getResources().getIdentifier("@drawable/logo_sidebar",
                null,
                context.getPackageName());
        holder.imageView.setImageResource(imageResource);
        holder.textViewTitle.setText(articleModel.getTitle());
        holder.textViewArticle.setText(articleModel.getArticleDetail());
        holder.imageView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Fragment fragment = new ArtikelDetailFragment();
                FragmentManager fragmentManager = articleModel.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.screen_area, fragment, "article list");
                fragmentTransaction.addToBackStack("article list");

                fragmentTransaction.commit();
            }
        });
    }

    @Override
    public int getItemCount(){ return articleModels.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewTitle;
        public TextView textViewArticle;

        public ViewHolder(View v){
            super(v);

            imageView = (ImageView) v.findViewById(R.id.article_image_view);
            textViewTitle = (TextView) v.findViewById(R.id.article_title_text_view);
            textViewArticle = (TextView) v.findViewById(R.id.article_detail_text_view);
        }
    }
}