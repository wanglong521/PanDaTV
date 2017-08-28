package com.example.admin.pandatv.view.fragment.ChinaModule;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.LvieItemBean;
import com.example.admin.pandatv.view.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/26.
 */

public class China_Item_Fragment extends BaseFragment{

    private RecyclerView china_recycler;
    private Bundle arguments;

    @Override
    public int getLayout() {
        return R.layout.china_fragment;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        ArrayList<LvieItemBean> list = new ArrayList<>();
        ArrayList<String> brief = arguments.getStringArrayList("brief");
        ArrayList<String> image = arguments.getStringArrayList("image");
        ArrayList<String> title = arguments.getStringArrayList("title");

        for (int i = 0; i < brief.size(); i++) {
                LvieItemBean bean = new LvieItemBean(brief.get(i)
                ,image.get(i),title.get(i));
            list.add(bean);
        }


    }

    @Override
    protected void initView(View view) {
//        china_item_brief = view.findViewById(R.id.china_item_brief);
//        china_item_image = view.findViewById(R.id.china_item_image);
//        china_item_title = view.findViewById(R.id.china_item_title);
//        china_item_updele = view.findViewById(R.id.china_item_updele);
        china_recycler = view.findViewById(R.id.china_recycler);
        arguments = getArguments();
    }
}
