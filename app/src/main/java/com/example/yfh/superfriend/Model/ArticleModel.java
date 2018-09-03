package com.example.yfh.superfriend.Model;

import android.support.v4.app.FragmentManager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ArticleModel {

    @SerializedName("id")
    @Expose
    private String id;

    private String srcImage, title, articleDetail;

    private FragmentManager fragmentManager;

    public ArticleModel(String id,
                        String srcImage,
                        String title,
                        String articleDetail,
                        FragmentManager fragmentManager){
        this.id = id;
        this.srcImage = srcImage;
        this.title = title;
        this.articleDetail = articleDetail;
        this.fragmentManager = fragmentManager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcImage() {
        return srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(String articleDetail) {
        this.articleDetail = articleDetail;
    }

    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }
}

