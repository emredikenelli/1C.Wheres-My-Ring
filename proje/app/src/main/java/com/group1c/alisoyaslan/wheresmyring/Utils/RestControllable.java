package com.group1c.alisoyaslan.wheresmyring.Utils;

import com.group1c.alisoyaslan.wheresmyring.Models.LoginValue;
import com.group1c.alisoyaslan.wheresmyring.Models.ResponsePHP;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by AliSoyaslan on 4.11.2017.
 */

public abstract class RestControllable {

    @POST("/Api/index.php/hello")
    public abstract Call<LoginValue> getUser(@Body RequestBody body);

    @POST("/Api/index.php/hello/signup/")
    public abstract Call<ResponsePHP> setUser(@Body RequestBody body);

}
