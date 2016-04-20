package com.loften.retrofit2sample.network.util;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by loften on 16/4/20.
 * 配置retrofit
 * 返回retrofit单例
 */
public class RetrofitUtils {

    private static Retrofit singleton;

    static <T> T createApi(Context context, Class<T> clazz, String host){
        if(singleton == null){
            synchronized (RetrofitUtils.class){
                if(singleton == null){
                    singleton = new Retrofit.Builder()
                            .baseUrl(host)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(OkHttpUtils.getSingleton(context))
                            .build();
                }
            }
        }


        return singleton.create(clazz);
    }

}
