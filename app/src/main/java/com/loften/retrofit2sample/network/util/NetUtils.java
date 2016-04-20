package com.loften.retrofit2sample.network.util;

/**
 * Created by loften on 16/4/20.
 * 设置网络配置
 * 调用api
 */
public abstract class NetUtils {
    public static NetConfig netConfig;

    public static void setNetConfig(NetConfig netConfig){
        NetUtils.netConfig = netConfig;
    }

    public static <T> T createApi(Class<T> clazz, String host){
        if(netConfig.context == null)
            throw new IllegalArgumentException("must be set Context,use NetUtils.setNetConfig() at once");
        return RetrofitUtils.createApi(netConfig.context,clazz,host);
    }
}
