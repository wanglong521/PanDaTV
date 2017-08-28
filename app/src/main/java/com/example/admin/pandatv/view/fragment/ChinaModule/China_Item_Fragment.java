package com.example.admin.pandatv.view.fragment.ChinaModule;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.LvieItemBean;
import com.example.admin.pandatv.view.adapter.China_Item_FragmentAdapter;
import com.example.admin.pandatv.view.base.BaseFragment;
import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by lenovo on 2017/8/26.
 *  直播中国内容Fragment
 */

public class China_Item_Fragment extends BaseFragment{
    private Bundle bundle;

    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {


        @Override
        public void onReceive(Context context, Intent intent) {
            bundle = intent.getBundleExtra("bundle");
            ArrayList<LvieItemBean> list = new ArrayList<>();
            ArrayList<String> brief = bundle.getStringArrayList("brief");
            ArrayList<String> image = bundle.getStringArrayList("image");
            ArrayList<String> title = bundle.getStringArrayList("title");
            for (int i = 0; i < brief.size(); i++) {
                LvieItemBean bean = new LvieItemBean(brief.get(i)
                        ,image.get(i),title.get(i));
                list.add(bean);
            }
            China_Item_FragmentAdapter adapter = new China_Item_FragmentAdapter(getActivity(),list);
            china_recycler.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
            china_recycler.setAdapter(adapter);
            Log.e("onReceive: ", bundle.toString());
        }
    };
    private RecyclerView china_recycler;

    @Override
    public int getLayout() {
        return R.layout.china_fragment;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
//        arguments = getArguments();
//        ArrayList<String> brief = arguments.getStringArrayList("brief");
//        ArrayList<String> image = arguments.getStringArrayList("image");
//        ArrayList<String> title = arguments.getStringArrayList("title");
    }

    @Override
    protected void initView(View view) {
//        china_item_brief = view.findViewById(R.id.china_item_brief);
//        china_item_image = view.findViewById(R.id.china_item_image);
//        china_item_title = view.findViewById(R.id.china_item_title);
//        china_item_updele = view.findViewById(R.id.china_item_updele);
        china_recycler = view.findViewById(R.id.china_recycler);
        IntentFilter filter = new IntentFilter();
        filter.addAction("aaa");
        getActivity().registerReceiver(broadcastReceiver,filter);
    }
}
