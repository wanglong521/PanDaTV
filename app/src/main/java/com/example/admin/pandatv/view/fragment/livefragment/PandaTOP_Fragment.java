package com.example.admin.pandatv.view.fragment.livefragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.adapter.PandaTOPAdapter;
import com.example.admin.pandatv.model.entity.PandaTOPBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplTOP;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.PandaTOPView;

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
