package com.loften.retrofit2sample.network.service;

import com.loften.retrofit2sample.bean.GrilBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by loften on 16/4/20.
 * api概览类
 */
public interface ApiOverview {

    @GET("txapi/mvtp/meinv")
    Call<GrilBean> getGril(@Header("apikey") String key, @Query("num") int num);

}
