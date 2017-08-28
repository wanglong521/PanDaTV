package com.example.admin.pandatv.view.fragment.livefragment;

import android.view.View;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.adapter.OtherAdapter;
import com.example.admin.pandatv.model.entity.SplendidBean;
import com.example.admin.pandatv.prosenter.IPresenterImplSplendid;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.SplendidView;

import java.util.ArrayList;
import java.util.List;

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
    @Override
    public int getLayout() {
        return R.layout.other_item;
    }

    @Override
    protected void initListener() {

    }



    @Override
    protected void initData() {

        IPresenterImplSplendid iPresenterImplSplendid=new IPresenterImplSplendid(this);

        iPresenterImplSplendid.Getcontroller();
    }

    @Override
    protected void initView(View view) {
        other_listview = view.findViewById(R.id.other_listview);
    }

    @Override
    public void OnSucceed(SplendidBean succed) {

        List<SplendidBean.VideoBean> video = succed.getVideo();

        splendidlist.addAll(video);

        OtherAdapter adapter=new OtherAdapter(getActivity(),splendidlist);

        other_listview.setAdapter(adapter);
    }

    @Override
    public void OnDefeated() {

    }
}
