package com.loften.retrofit2sample.common;

import android.app.Application;
import android.content.Context;

import com.loften.retrofit2sample.network.util.NetConfig;
import com.loften.retrofit2sample.network.util.NetConfigBuilder;
import com.loften.retrofit2sample.network.util.NetUtils;

import java.io.File;

/**
 * Created by loften on 16/4/19.
 */
public class App extends Application{
    private static Context context;

    //获取全局context
    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        /**
         * net config
         */
        final NetConfig netConfig = new NetConfigBuilder()
                .context(this)
                .responseCacheDir(new File(context.getCacheDir(),"mycache"))
                .responseCacheSize(1024 * 1024 * 100)
                .readTimeout(2000)
                .createNetConfig();
        NetUtils.setNetConfig(netConfig);
    }
}
