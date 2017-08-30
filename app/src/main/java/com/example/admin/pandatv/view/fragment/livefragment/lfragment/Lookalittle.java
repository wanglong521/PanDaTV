package com.example.admin.pandatv.view.fragment.livefragment.lfragment;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.view.ClearEditText;

/**
 * Created by LiYRong on 2017/8/26.
 */
// TODO: 2017/8/29 差网址
public class Lookalittle extends BaseFragment {

    private ClearEditText ed_comment;
    private Button send;
    private ListView look_litview;

    @Override
    public int getLayout() {
        return R.layout.lookalittle_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

        ed_comment = view.findViewById(R.id.ed_comment);
        send = view.findViewById(R.id.send);
        look_litview = view.findViewById(R.id.look_litview);
    }
}
