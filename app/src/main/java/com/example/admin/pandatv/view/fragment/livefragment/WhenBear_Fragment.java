package com.example.admin.pandatv.view.fragment.livefragment;

import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.adapter.WhenAdapter;
import com.example.admin.pandatv.model.entity.WhenBreadBean;
import com.example.admin.pandatv.prosenter.IPresenterImplWhenBread;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.WhenBreadView;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrClassicDefaultFooter;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by LiYRong on 2017/8/25.
 *
 *
 *          当熊不让
 */
//这是小媛荣的代码
public class WhenBear_Fragment extends BaseFragment implements WhenBreadView{

    private ListView other_listview;
    private List<WhenBreadBean.VideoBean> whenbreadlist=new ArrayList<WhenBreadBean.VideoBean>();
    private PtrFrameLayout ptrFrameLayout;
    private WhenAdapter adapter;
    private int a=1;
    private IPresenterImplWhenBread iPresenterImplWhenBread;

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

                a=1;
                iPresenterImplWhenBread.GetcontrollerWhenBread(a);
                frame.refreshComplete();

            }
        });


    }

    @Override
    protected void initData() {

        iPresenterImplWhenBread = new IPresenterImplWhenBread(this);
        iPresenterImplWhenBread.GetcontrollerWhenBread(a);

    }

    @Override
    protected void initView(View view) {

        other_listview = view.findViewById(R.id.other_listview);

        ptrFrameLayout = view.findViewById(R.id.Splendidptr);

        PtrClassicDefaultHeader header=new PtrClassicDefaultHeader(App.mBaseActivity);
        PtrClassicDefaultFooter footer=new PtrClassicDefaultFooter(App.mBaseActivity);

        header.setPadding(0,10,0,15);
        ptrFrameLayout.setHeaderView(header);
        ptrFrameLayout.addPtrUIHandler(header);
        ptrFrameLayout.setFooterView(footer);
        ptrFrameLayout.addPtrUIHandler(footer);

        adapter = new WhenAdapter(getActivity(),whenbreadlist);
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
        Log.e("TAG","失败");
    }
}
