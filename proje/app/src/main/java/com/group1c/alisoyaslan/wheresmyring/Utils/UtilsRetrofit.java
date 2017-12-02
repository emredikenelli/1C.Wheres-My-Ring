package com.group1c.alisoyaslan.wheresmyring.Utils;

import android.content.Context;

import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AliSoyaslan on 4.11.2017.
 */

class UtilsRetrofit {

    public static OkHttpClient createClient(Context mContext){
        OkHttpClient result = new HttpClientHelper(mContext).newBuilder()
                .addInterceptor(new NetworkInterceptorHelper(mContext))
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();

        return result;
    }

    public static Retrofit createRetrofitAdapter(Context mContext, String baseUrl){
        return new Retrofit.Builder()
                .client(UtilsRetrofit.createClient(mContext))
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(UtilsGson.createGson()))
                .build();

    }


}
