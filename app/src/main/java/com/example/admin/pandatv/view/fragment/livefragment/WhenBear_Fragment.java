package com.example.admin.pandatv.view.fragment.livefragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.adapter.WhenAdapter;
import com.example.admin.pandatv.model.bean.FLFBen;
import com.example.admin.pandatv.model.entity.livapandabean.WhenBreadBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplWhenBread;
import com.example.admin.pandatv.view.activity.banderavtivitys.FristActivity;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.UrlUtils;
import com.example.admin.pandatv.view.base.WhenBreadView;
import com.google.gson.Gson;
import com.squareup.okhttp.Request;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiYRong on 2017/8/25.
 * <p>
 * <p>
 * 当熊不让
 */
//这是小媛荣的代码
public class WhenBear_Fragment extends BaseFragment implements WhenBreadView {

    private ListView other_listview;
    private List<WhenBreadBean.VideoBean> whenbreadlist = new ArrayList<WhenBreadBean.VideoBean>();
    private PtrFrameLayout ptrFrameLayout;
    private WhenAdapter adapter;
    private int a = 1;
    private IPresenterImplWhenBread iPresenterImplWhenBread;
    private String url;
    private String url1;
    String uri;

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
                iPresenterImplWhenBread.GetcontrollerWhenBread(a);
                frame.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                whenbreadlist.clear();

                a = 1;
                iPresenterImplWhenBread.GetcontrollerWhenBread(a);
                frame.refreshComplete();

            }
        });
        //视频监听
        other_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                url1 = whenbreadlist.get(i).getVid();
                Log.e("TAG", "onItemClick:" + url1.toString());
                OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + url1, new OkHttpClientManager.ResultCallback<String>() {

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                        uri = flfBen.getVideo().getChapters().get(0).getUrl();
                        Log.e("TAG", "onResponse: " + url1.toString());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent1 = new Intent(App.mBaseActivity, FristActivity.class);
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

        whenbreadlist.clear();

        iPresenterImplWhenBread = new IPresenterImplWhenBread(this);
        iPresenterImplWhenBread.GetcontrollerWhenBread(a);

    }

    @Override
    protected void initView(View view) {

        other_listview = view.findViewById(R.id.other_listview);

        ptrFrameLayout = view.findViewById(R.id.Splendidptr);

        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(App.mBaseActivity);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(App.mBaseActivity);

        header.setPadding(0, 10, 0, 15);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(footer);

        adapter = new WhenAdapter(getActivity(), whenbreadlist);
        other_listview.setAdapter(adapter);

    }

    @Override
    public void OnSucceed(WhenBreadBean succed) {

        List<WhenBreadBean.VideoBean> video = succed.getVideo();

        whenbreadlist.addAll(video);

        adapter.notifyDataSetChanged();


    }

    @Override
    public void OnDefeated() {
        Log.e("TAG", "失败");
    }
}
