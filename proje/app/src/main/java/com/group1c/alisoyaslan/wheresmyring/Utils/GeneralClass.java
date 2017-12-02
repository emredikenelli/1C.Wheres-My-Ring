package com.group1c.alisoyaslan.wheresmyring.Utils;

import android.app.Application;

import retrofit2.Retrofit;

/**
 * Created by AliSoyaslan on 4.11.2017.
 */

public class GeneralClass extends Application {

    private static GeneralClass instance;
    public Retrofit restAdapter;
    public RestControllable restInterface;
    final String URL = "https://web-api-ali-barisatalay.c9users.io/";

    public static GeneralClass getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        restAdapter = UtilsRetrofit.createRetrofitAdapter(getApplicationContext(), URL);
        restInterface = restAdapter.create(RestControllable.class);

    }

}