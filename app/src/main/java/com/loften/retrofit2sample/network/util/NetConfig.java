package com.loften.retrofit2sample.network.util;

import android.content.Context;

import java.io.File;

/**
 * Created by loften on 16/4/20.
 * Net 配置
 */
public class NetConfig {
    File RESPONSE_CACHE;//缓存文件
    int RESPONSE_CACHE_SIZE;//缓存文件大小
    int CONNET_TIMEOUT;//连接超时
    int READ_TIMEOUT;//读取新链接超时
    int MAX_CACHE_AGE;//从文档被访问后的存活时间
    Context context;

    public NetConfig(File RESPONSE_CACHE,int RESPONSE_CACHE_SIZE,int CONNET_TIMEOUT,int READ_TIMEOUT,int MAX_CACHE_AGE,Context context){
        this.RESPONSE_CACHE = RESPONSE_CACHE;
        this.RESPONSE_CACHE_SIZE = RESPONSE_CACHE_SIZE;
        this.CONNET_TIMEOUT = CONNET_TIMEOUT;
        this.READ_TIMEOUT = READ_TIMEOUT;
        this.MAX_CACHE_AGE = MAX_CACHE_AGE;
        this.context = context;
    }
}
