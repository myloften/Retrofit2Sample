package com.loften.retrofit2sample.base;

import android.view.View;
import android.view.ViewGroup;

/**
 * Created by loften on 16/4/12.
 */
public interface OnItemClickListener<T> {
    void onItemClick(ViewGroup parent, View view, T t, int position);
    boolean onItemLongClick(ViewGroup parent, View view, T t, int position);
}
