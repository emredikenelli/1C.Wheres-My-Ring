package com.group1c.alisoyaslan.wheresmyring.Utils;

import android.content.Context;



import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by AliSoyaslan on 4.11.2017.
 */

public class NetworkInterceptorHelper implements Interceptor {
    private String TAG = this.getClass().getSimpleName();

    public Context mContext;

    public NetworkInterceptorHelper(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        if (!UtilsGeneral.networkControl(mContext)){
            throw new IOException("Internet Yok");
        }

        return chain.proceed(request);
    }
}