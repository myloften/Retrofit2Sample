package com.loften.retrofit2sample.network.util;

import android.content.Context;

import com.loften.retrofit2sample.common.App;
import com.loften.retrofit2sample.utils.NetUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by loften on 16/4/20.
 * 配置OkHttp
 */
public class OkHttpUtils {

    private final static File RESPONSE_CACHE = NetUtils.netConfig.RESPONSE_CACHE;
    private final static int RESPONSE_CACHE_SIZE = NetUtils.netConfig.RESPONSE_CACHE_SIZE;
    private final static int CONNECT_TIMEOUT = NetUtils.netConfig.CONNET_TIMEOUT;
    private final static int READ_TIMEOUT = NetUtils.netConfig.READ_TIMEOUT;
    private static OkHttpClient singleton;

    static OkHttpClient getSingleton(final Context context){
        if(singleton == null){
            synchronized (OkHttpUtils.class){
                if(singleton == null){
                    singleton = new OkHttpClient().newBuilder()
                            .cache(new Cache(RESPONSE_CACHE != null?RESPONSE_CACHE:new File(context.getCacheDir(),"defalut_cache"),RESPONSE_CACHE_SIZE))
                            .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                            .build();
                }
            }
        }
        return singleton;
    }

    private static final Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Response originalResponse = chain.proceed(chain.request());
            if (NetUtil.isNetworkAvailable(App.getContext())) {
                int maxAge = 60; // 在线缓存在1分钟内可读取
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // 离线时缓存保存4周
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        }
    };
}
