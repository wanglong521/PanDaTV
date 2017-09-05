package com.example.admin.pandatv.view.fragment.livefragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.adapter.PandaFilesAdapter;
import com.example.admin.pandatv.model.bean.FLFBen;
import com.example.admin.pandatv.model.entity.livapandabean.PandaFilesBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplPanFiles;
import com.example.admin.pandatv.view.activity.banderavtivitys.FristActivity;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.PandaFilesView;
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
 * <p>
 * 熊猫档案
 */

//这是小媛荣的代码
public class PandaFiles_Fragment extends BaseFragment implements PandaFilesView {

    private PtrFrameLayout ptrFrameLayout;
    private ListView other_listview;
    private List<PandaFilesBean.VideoBean> panfileslist = new ArrayList<PandaFilesBean.VideoBean>();

    private int a = 1;
    private PandaFilesAdapter adapter;
    private IPresenterImplPanFiles iPresenterImplPanFiles;
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
                iPresenterImplPanFiles.GetcontrollerPanfiles(a);
                frame.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                panfileslist.clear();
                a = 1;
                iPresenterImplPanFiles.GetcontrollerPanfiles(a);
                frame.refreshComplete();

            }
        });
        other_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                vid = panfileslist.get(i).getVid();
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

        panfileslist.clear();

        iPresenterImplPanFiles = new IPresenterImplPanFiles(this);

        iPresenterImplPanFiles.GetcontrollerPanfiles(a);


    }

    @Override
    protected void initView(View view) {

        ptrFrameLayout = view.findViewById(R.id.Splendidptr);
        other_listview = view.findViewById(R.id.other_listview);

        PtrClassicDefaultHeader header = new PtrClassicDefaultHeader(App.mBaseActivity);
        PtrClassicDefaultFooter footer = new PtrClassicDefaultFooter(App.mBaseActivity);

        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(footer);

        adapter = new PandaFilesAdapter(getActivity(), panfileslist);

        other_listview.setAdapter(adapter);

    }

    @Override
    public void OnSucceed(PandaFilesBean succed) {

        List<PandaFilesBean.VideoBean> video = succed.getVideo();

        panfileslist.addAll(video);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnDefeated() {
        Log.e("TAG", "失败");
    }
}
