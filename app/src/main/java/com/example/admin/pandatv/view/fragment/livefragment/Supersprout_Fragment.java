package com.example.admin.pandatv.view.fragment.livefragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.adapter.SupersAdapter;
import com.example.admin.pandatv.model.entity.livapandabean.SupersBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImolSupers;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.SupersView;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiYRong on 2017/8/25.
 *
 *          超萌滚滚秀
 */
//这是小媛荣的代码
public class Supersprout_Fragment extends BaseFragment implements SupersView{

    private PtrFrameLayout ptrFrameLayout;
    private ListView other_listview;

    private List<SupersBean.VideoBean> superslist=new ArrayList<SupersBean.VideoBean>();
    private SupersAdapter adapter;
    private int a=1;
    private IPresenterImolSupers iPresenterImolSupers;

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
                iPresenterImolSupers.GetcontrollerSupers(a);
                frame.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                superslist.clear();
                a=1;
                iPresenterImolSupers.GetcontrollerSupers(a);
                frame.refreshComplete();

            }
        });


    }

    @Override
    protected void initData() {

        superslist.clear();
        iPresenterImolSupers = new IPresenterImolSupers(this);
        iPresenterImolSupers.GetcontrollerSupers(a);

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

        adapter = new SupersAdapter(getActivity(),superslist);

        other_listview.setAdapter(adapter);


    }

    @Override
    public void OnSucceed(SupersBean succed) {

        List<SupersBean.VideoBean> video = succed.getVideo();

        superslist.addAll(video);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnDefeated() {
        Log.e("TAG","失败");
    }
}
