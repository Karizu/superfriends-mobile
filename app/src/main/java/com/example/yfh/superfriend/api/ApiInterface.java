package com.example.yfh.superfriend.api;

import com.example.yfh.superfriend.Model.ArticleModel;
import com.example.yfh.superfriend.Model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @POST("login")
    Call<UserModel> login(@Field("username") String username, @Field("password") String password);

}
