package com.loften.retrofit2sample.network.manager;

import com.loften.retrofit2sample.common.Constant;
import com.loften.retrofit2sample.network.service.ApiOverview;
import com.loften.retrofit2sample.network.util.NetUtils;

/**
 * Created by loften on 16/4/20.
 */
public class MyNet {
    public static ApiOverview get(){
        return NetUtils.createApi(ApiOverview.class, Constant.url);
    }
}
