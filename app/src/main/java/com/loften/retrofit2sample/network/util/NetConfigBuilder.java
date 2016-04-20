package com.loften.retrofit2sample.network.util;

import android.content.Context;

import java.io.File;

/**
 * Created by loften on 16/4/20.
 * 通过构建者模式初始化配置NetConfig
 */
public class NetConfigBuilder {

    private File response_cache;
    private int response_cache_size = 5 * 1024 * 1024;
    private int connect_timeout = 8 * 1000;
    private int read_timeout = 5 * 1000;
    private Context appContext;
    private int maxCacheAge = 0;

    /**
     * request cache-control
     */
    public NetConfigBuilder maxCacheAge(int maxCacheAge) {
        this.maxCacheAge = maxCacheAge;
        return this;
    }

    /**
     * local cache dir
     */
    public NetConfigBuilder responseCacheDir(File response_cache) {
        this.response_cache = response_cache;
        return this;
    }

    /**
     * local cache size
     */
    public NetConfigBuilder responseCacheSize(int response_cache_size) {
        this.response_cache_size = response_cache_size;
        return this;
    }

    /**
     * readTime
     *
     * @param connect_timeout millisecond
     */
    public NetConfigBuilder connectionTimeout(int connect_timeout) {
        this.connect_timeout = connect_timeout;
        return this;
    }

    /**
     * timeout
     *
     * @param read_timeout millisecond
     */
    public NetConfigBuilder readTimeout(int read_timeout) {
        this.read_timeout = read_timeout;
        return this;
    }

    /**
     * must set Context
     */
    public NetConfigBuilder context(Context app) {
        this.appContext = app.getApplicationContext();
        return this;
    }

    public NetConfig createNetConfig() {
        return new NetConfig(response_cache, response_cache_size, connect_timeout, read_timeout, maxCacheAge, appContext);
    }
}
