package com.example.admin.pandatv.view.fragment.livefragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.adapter.PThingAdapter;
import com.example.admin.pandatv.model.entity.PandaThingBean;
import com.example.admin.pandatv.prosenter.IPresenterImplThing;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.PandatingView;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiYRong on 2017/8/25.
 *
 *      熊猫那些事
 *
 */
//这是小媛荣的代码
public class Pandathing_Fragment extends BaseFragment implements PandatingView{

    private PtrFrameLayout ptrFrameLayout;
    private ListView other_listview;
    private int a=1;
    private List<PandaThingBean.VideoBean> thinglist=new ArrayList<PandaThingBean.VideoBean>();
    private PThingAdapter adapter;
    private IPresenterImplThing iPresenterImplThing;

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
                iPresenterImplThing.GetcontrollerPanTing(a);
                frame.refreshComplete();

            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                thinglist.clear();
                a=1;
                iPresenterImplThing.GetcontrollerPanTing(a);
                frame.refreshComplete();

            }
        });


    }

    @Override
    protected void initData() {

        iPresenterImplThing = new IPresenterImplThing(this);
        iPresenterImplThing.GetcontrollerPanTing(a);

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

        adapter = new PThingAdapter(getActivity(),thinglist);

        other_listview.setAdapter(adapter);

    }

    @Override
    public void OnSucceed(PandaThingBean succed) {

        List<PandaThingBean.VideoBean> video = succed.getVideo();

        thinglist.addAll(video);

        adapter.notifyDataSetChanged();

    }

    @Override
    public void OnDefeated() {
        Log.e("TAG","失败");
    }
}
