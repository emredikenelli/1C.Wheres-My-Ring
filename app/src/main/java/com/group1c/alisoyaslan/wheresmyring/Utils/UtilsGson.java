package com.group1c.alisoyaslan.wheresmyring.Utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import okhttp3.RequestBody;
import retrofit2.http.Field;

/**
 * Created by AliSoyaslan on 4.11.2017.
 */

public class UtilsGson {

    public static Gson createGson(){
        ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {

            @Override
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return clazz == Field.class || clazz == Method.class;
            }
        };

        GsonBuilder builder = new GsonBuilder();
        builder.addSerializationExclusionStrategy(exclusionStrategy)
//                .registerTypeAdapterFactory(new RetrofitParserHelper())
                .addDeserializationExclusionStrategy(exclusionStrategy)
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .serializeNulls();


        return builder.create();
    }

    public static RequestBody converteRetrofit(JSONObject jsonParams){
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),jsonParams.toString());
    }

    public static RequestBody converteRetrofitWithString(JSONObject jsonParams){
        return RequestBody.create(okhttp3.MediaType.parse("charset=utf-8"),jsonParams.toString());
    }

    public static RequestBody converteRetrofit(String jsonParams){
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),jsonParams.isEmpty()?"{}":jsonParams);
    }

}
