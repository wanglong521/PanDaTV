package com.example.admin.pandatv.view.fragment.livefragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.adapter.OtherAdapter;
import com.example.admin.pandatv.model.bean.FLFBen;
import com.example.admin.pandatv.model.entity.livapandabean.SplendidBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplSplendid;
import com.example.admin.pandatv.view.activity.banderavtivitys.FristActivity;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.SplendidView;
import com.example.admin.pandatv.view.base.UrlUtils;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * Created by LiYRong on 2017/8/25.
 *
 *            精彩一刻
 *
 */
//这是小媛荣的代码
public class Splendid_Fragment extends BaseFragment implements SplendidView {

    private ListView other_listview;
    private List<SplendidBean.VideoBean> splendidlist=new ArrayList<SplendidBean.VideoBean>();
    private OtherAdapter adapter;
    private int a = 1;
    private IPresenterImplSplendid iPresenterImplSplendid;
    private in.srain.cube.views.ptr.PtrFrameLayout ptrFrameLayout;
    private String url;
    private String uri;

    @Override
    public int getLayout() {
        return R.layout.other_item;
    }

    @Override
    protected void initListener() {
        ptrFrameLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                a++;
                iPresenterImplSplendid.GetcontrollerSplendid(a);
                frame.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                splendidlist.clear();
                a=1;
                iPresenterImplSplendid.GetcontrollerSplendid(a);
                frame.refreshComplete();
            }
        });

        other_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                url = splendidlist.get(i).getVid();
                Log.e("TAG", "onItemClick:" + url.toString());
                OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + url, new OkHttpClientManager.ResultCallback<String>() {
                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                        uri = flfBen.getVideo().getChapters().get(0).getUrl();
                        Log.e("TAG", "onResponse: " + url.toString());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(getActivity(), FristActivity.class);
                                intent1.putExtra("url", uri);
                                getActivity().startActivity(intent1);
                            }
                        });


                    }
                });
            }
        });


    }



    @Override
    protected void initData() {

        splendidlist.clear();

        iPresenterImplSplendid = new IPresenterImplSplendid(this);
        iPresenterImplSplendid.GetcontrollerSplendid(a);
    }

    @Override
    protected void initView(View view) {
        ptrFrameLayout = view.findViewById(R.id.Splendidptr);
        in.srain.cube.views.ptr.PtrClassicDefaultHeader header=new in.srain.cube.views.ptr.PtrClassicDefaultHeader(App.mBaseActivity);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(App.mBaseActivity);
        header.setPadding(0,10,0,15);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(footer);


        
        other_listview = view.findViewById(R.id.other_listview);
        adapter = new OtherAdapter(getActivity(),splendidlist);
        other_listview.setAdapter(adapter);

    }

    @Override
    public void OnSucceed(SplendidBean succed) {
        Log.e("TAG",succed.toString());
        List<SplendidBean.VideoBean> video = succed.getVideo();

        splendidlist.addAll(video);

       adapter.notifyDataSetChanged();
    }

    @Override
    public void OnDefeated() {
        Log.e("TAG","失败");
    }
}
