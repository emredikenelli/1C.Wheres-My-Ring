package com.group1c.alisoyaslan.wheresmyring.Utils;

import android.content.Context;

import okhttp3.OkHttpClient;


/**
 * Created by AliSoyaslan on 4.11.2017.
 */

public class HttpClientHelper extends OkHttpClient {
    private Context mContext;

    public HttpClientHelper(Context mContext){
        this.mContext = mContext;
    }
}