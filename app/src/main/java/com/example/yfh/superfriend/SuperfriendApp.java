package com.example.yfh.superfriend;

import android.app.Application;
import android.content.Context;

import com.example.yfh.superfriend.api.ApiInterface;
import com.rezkyatinnov.kyandroid.Kyandroid;
import com.rezkyatinnov.kyandroid.localdata.KyandroidRealmModule;

public class SuperfriendApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Kyandroid.init(this,"http://37.72.172.144/superfriends-api/public/api/", ApiInterface.class,"superfriendapp", Context.MODE_PRIVATE
        ,"superfrienddb",1,false, new KyandroidRealmModule());

    }
}
