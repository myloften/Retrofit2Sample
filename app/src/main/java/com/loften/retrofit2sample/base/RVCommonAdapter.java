package com.loften.retrofit2sample.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by loften on 16/4/12.
 * RecyclerView 的Adapter基类
 */
public abstract class RVCommonAdapter<T> extends RecyclerView.Adapter<ViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener = onItemClickListener;
    }

    public RVCommonAdapter(Context context, int layoutId, List<T> datas){
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        ViewHolder viewHolder = ViewHolder.get(mContext, null, parent, mLayoutId, -1);
        setListener(parent, viewHolder, viewType);
        return viewHolder;
    }

    protected int getPosition(RecyclerView.ViewHolder viewHolder){
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType){
        return true;
    }

    //正常的item是从1开始的，0是header，所以获取正常item的时候是position-1
    protected void setListener(final ViewGroup parent, final ViewHolder viewHolder, int viewType){
        if(!isEnabled(viewType)) return;
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mOnItemClickListener != null){
                    int position = getPosition(viewHolder);
                    mOnItemClickListener.onItemClick(parent,v,mDatas.get(position-1),position-1);
                }
            }
        });

        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mOnItemClickListener != null){
                    int position = getPosition(viewHolder);
                    return mOnItemClickListener.onItemLongClick(parent,v,mDatas.get(position-1),position-1);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updatePosition(position);
        convert(holder,mDatas.get(position));
    }

    public abstract void convert(ViewHolder holder,T t);

}
