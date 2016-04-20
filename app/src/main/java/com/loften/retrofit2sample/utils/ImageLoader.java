package com.loften.retrofit2sample.utils;

import android.content.Context;
import android.widget.ImageView;

import com.loften.retrofit2sample.R;
import com.squareup.picasso.Picasso;

/**
 * Created by loften on 16/4/19.
 * picasso图片加载工具类
 */
public class ImageLoader {

    public static void loadImage(Context context,String url,ImageView image){
        Picasso.with(context).setIndicatorsEnabled(true);
        Picasso.with(context).load(url).placeholder(R.mipmap.ic_holding).error(R.mipmap.ic_error).into(image);
    }
}
