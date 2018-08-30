package com.example.yfh.superfriend.Service;

import android.content.Context;
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

public class AdapterListMenuHome extends RecyclerView.Adapter<AdapterListMenuHome.ViewHolder> {
    private List<ArticleModel> articleModels;
    private Context context;

    public AdapterListMenuHome(List<ArticleModel> articleModels, Context context){
        this.articleModels = articleModels;
        this.context = context;
    }

    @Override
    public AdapterListMenuHome.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_card_view, parent, false);

        return new AdapterListMenuHome.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AdapterListMenuHome.ViewHolder holder, int position){
        final ArticleModel articleModel = articleModels.get(position);
        int imageResource = context.getResources().getIdentifier("@drawable/image_4",
                null,
                context.getPackageName());
        holder.imageView.setImageResource(imageResource);
        holder.textViewTitle.setText(articleModel.getTitle());
        holder.textViewDetail.setText(articleModel.getArticleDetail());
    }

    @Override
    public int getItemCount(){ return articleModels.size();}
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textViewTitle;
        public TextView textViewDetail;

        public ViewHolder(View v){
            super(v);

            imageView = (ImageView) v.findViewById(R.id.home_image_view);
            textViewTitle = (TextView) v.findViewById(R.id.title_home_card_view);
            textViewDetail = (TextView) v.findViewById(R.id.detail_home_card_view);
        }
    }
}
