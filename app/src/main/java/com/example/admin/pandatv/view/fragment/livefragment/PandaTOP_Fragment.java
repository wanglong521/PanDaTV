package com.example.admin.pandatv.view.fragment.livefragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.adapter.PandaTOPAdapter;
import com.example.admin.pandatv.model.bean.FLFBen;
import com.example.admin.pandatv.model.entity.livapandabean.PandaTOPBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplTOP;
import com.example.admin.pandatv.view.activity.banderavtivitys.FristActivity;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.PandaTOPView;
import com.example.admin.pandatv.view.base.UrlUtils;
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
 *
 *          熊猫TOP榜
 *
 */
//这是小媛荣的代码
public class PandaTOP_Fragment extends BaseFragment implements PandaTOPView{

    private ListView other_listview;
    private PtrFrameLayout ptrFrameLayout;
    private int a=1;
    private List<PandaTOPBean.VideoBean> toplist=new ArrayList<PandaTOPBean.VideoBean>();
    private PandaTOPAdapter adapter;
    private IPresenterImplTOP iPresenterImplTOP;
    private String vid;
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
                iPresenterImplTOP.GetcontrollerPanTOP(a);
                frame.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                toplist.clear();
                a=1;
                iPresenterImplTOP.GetcontrollerPanTOP(a);
                frame.refreshComplete();

            }
        });
        //视频点击事件
        other_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vid = toplist.get(i).getVid();
                Log.e("TAG", "onItemClick:" + vid.toString());
                OkHttpClientManager.getAsyn(UrlUtils.LUNBOOUT + vid, new OkHttpClientManager.ResultCallback<String>() {

                    @Override
                    public void onError(Request request, Exception e) {

                    }

                    @Override
                    public void onResponse(String response) {
                        FLFBen flfBen = new Gson().fromJson(response, FLFBen.class);
                     uri = flfBen.getVideo().getChapters().get(0).getUrl();
                        Log.e("TAG", "onResponse: " + uri.toString());
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

        toplist.clear();
        iPresenterImplTOP = new IPresenterImplTOP(this);
        iPresenterImplTOP.GetcontrollerPanTOP(a);

    }

    @Override
    protected void initView(View view) {

        other_listview = view.findViewById(R.id.other_listview);
        ptrFrameLayout = view.findViewById(R.id.Splendidptr);

        PtrClassicDefaultHeader header=new PtrClassicDefaultHeader(App.mBaseActivity);
        PtrClassicDefaultFooter footer=new PtrClassicDefaultFooter(App.mBaseActivity);

        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(footer);

        adapter = new PandaTOPAdapter(getActivity(),toplist);

        other_listview.setAdapter(adapter);

    }

    @Override
    public void OnSucceed(PandaTOPBean succed) {

        List<PandaTOPBean.VideoBean> video = succed.getVideo();

        toplist.addAll(video);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnDefeated() {
        Log.e("TAG","失败");
    }
}
