package com.example.admin.pandatv.view.fragment.livefragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.adapter.SpecialAdapter;
import com.example.admin.pandatv.model.entity.livapandabean.SpecialBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPersenterImplSpecial;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.SpecialView;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiYRong on 2017/8/25.
 *
 *          特别节目
 */
//这是小媛荣的代码
public class Special_Fragment extends BaseFragment implements SpecialView {

    private PtrFrameLayout ptrFrameLayout;
    private ListView other_listview;
    private int a=1;
    private List<SpecialBean.VideoBean> speciallist=new ArrayList<SpecialBean.VideoBean>();
    private SpecialAdapter adapter;
    private IPersenterImplSpecial iPersenterImplSpecial;

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
                iPersenterImplSpecial.GetcontrollerSpecial(a);
                frame.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                speciallist.clear();
                a=1;
                iPersenterImplSpecial.GetcontrollerSpecial(a);
                frame.refreshComplete();

            }
        });


    }

    @Override
    protected void initData() {

        speciallist.clear();

        iPersenterImplSpecial = new IPersenterImplSpecial(this);

        iPersenterImplSpecial.GetcontrollerSpecial(a);
    }

    @Override
    protected void initView(View view) {

        ptrFrameLayout = view.findViewById(R.id.Splendidptr);

        other_listview = view.findViewById(R.id.other_listview);

        PtrClassicDefaultHeader header=new PtrClassicDefaultHeader(App.mBaseActivity);
        PtrClassicDefaultFooter footer=new PtrClassicDefaultFooter(App.mBaseActivity);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(footer);

        adapter = new SpecialAdapter(getActivity(),speciallist);

        other_listview.setAdapter(adapter);

    }

    @Override
    public void OnSucceed(SpecialBean succed) {

        List<SpecialBean.VideoBean> video = succed.getVideo();

        speciallist.addAll(video);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnDefeated() {
        Log.e("TAG","失败");
    }
}
