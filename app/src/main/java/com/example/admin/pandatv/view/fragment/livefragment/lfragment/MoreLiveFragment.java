package com.example.admin.pandatv.view.fragment.livefragment.lfragment;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.adapter.MoreRAdapter;
import com.example.admin.pandatv.model.entity.livapandabean.LiveMBean;
import com.example.admin.pandatv.model.entity.livapandabean.MoreBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplLivemBean;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.LiveMBeanView;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYRong on 2017/8/26.
 */

public class MoreLiveFragment extends BaseFragment implements LiveMBeanView{

    private RecyclerView more_recycler;
    private List<LiveMBean.BookmarkBean.MultipleBean> list=new ArrayList<LiveMBean.BookmarkBean.MultipleBean>();

    private List<MoreBean.ListBean> morelist=new ArrayList<MoreBean.ListBean>();
    private MoreRAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.morelive_item;
    }

    @Override
    protected void initListener() {

    }
    @Override
    protected void initData() {

        morelist.clear();
        IPresenterImplLivemBean iPresenterImplLivemBean=new IPresenterImplLivemBean(this);
        iPresenterImplLivemBean.Getcontroller();

    }

    @Override
    protected void initView(View view) {

        more_recycler = view.findViewById(R.id.more_recycler);
        more_recycler.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));

//        more_recycler.setLayoutManager(new LinearLayoutManager(getActivity(),3,false));

        adapter = new MoreRAdapter(getActivity(),morelist);

        more_recycler.setAdapter(adapter);
        more_recycler.setNestedScrollingEnabled(false);

    }

    @Override
    public void OnSucceed(LiveMBean succed) {


        LiveMBean.BookmarkBean bookmark = succed.getBookmark();
        List<LiveMBean.BookmarkBean.MultipleBean> multiple = bookmark.getMultiple();

        list.addAll(multiple);

        String  url = list.get(0).getUrl();

        OkHttpClientManager.getAsyn(url, new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {

                Gson gson=new Gson();

                MoreBean moreBean = gson.fromJson(response.toString(), MoreBean.class);

                List<MoreBean.ListBean> list = moreBean.getList();

                morelist.clear();
                morelist.addAll(list);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        adapter.notifyDataSetChanged();
                    }
                });

            }
        });

    }

    @Override
    public void OnDefeated() {

        Log.e("TAG","请求失败");
    }
}
