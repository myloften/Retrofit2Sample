package com.loften.retrofit2sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.loften.retrofit2sample.base.RVCommonAdapter;
import com.loften.retrofit2sample.base.ViewHolder;
import com.loften.retrofit2sample.bean.GrilBean;
import com.loften.retrofit2sample.common.Constant;
import com.loften.retrofit2sample.network.manager.MyNet;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private XRecyclerView sRecyclerView;
    private RVCommonAdapter<GrilBean.NewslistEntity> sAdapter;
    List<GrilBean.NewslistEntity> data = new ArrayList<GrilBean.NewslistEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        getGrilInfo();
        initRefreash();

    }

    /**
     * 初始化RecyclerView
     */
    private void initView(){
        sRecyclerView = (XRecyclerView)findViewById(R.id.myrecyclerview);
    }

    /**
     * 初始化下拉组件
     */
    private void initRefreash() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        sRecyclerView.setLayoutManager(layoutManager);

        sRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        sRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);

        sRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                if(data!=null&&data.size()>0){
                    data.clear();
                }
                getGrilInfo();
            }

            @Override
            public void onLoadMore() {
                getGrilInfo();
            }
        });



    }

    private void getGrilInfo() {

        Call<GrilBean> call = MyNet.get().getGril(Constant.AES_KEY,12);
        call.enqueue(new Callback<GrilBean>() {
            @Override
            public void onResponse(Call<GrilBean> call, Response<GrilBean> response) {
                if (response.isSuccessful()) {
                    GrilBean result = response.body();
                    for(int i=0;i<result.getNewslist().size();i++) {
                        data.add(result.getNewslist().get(i));
                    }
                    if(data.size()<=15||sAdapter==null) {
                        sAdapter = new RVCommonAdapter<GrilBean.NewslistEntity>(MainActivity.this, R.layout.item_news_list_date, data) {

                            @Override
                            public void convert(ViewHolder holder, GrilBean.NewslistEntity newslistEntity) {
                                holder.setUrl(R.id.iv_news, newslistEntity.getPicUrl());
                                holder.setText(R.id.tv_news_date, newslistEntity.getCtime());
                                holder.setText(R.id.tv_title,newslistEntity.getTitle());
                            }
                        };

                        sRecyclerView.setAdapter(sAdapter);
                    }else {
                        sAdapter.notifyDataSetChanged();
                        sRecyclerView.refreshComplete();
                    }
                }
                sRecyclerView.refreshComplete();
            }

            @Override
            public void onFailure(Call<GrilBean> call, Throwable t) {

            }
        });
    }
}
