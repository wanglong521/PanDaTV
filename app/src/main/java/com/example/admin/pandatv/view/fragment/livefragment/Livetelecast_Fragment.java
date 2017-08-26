package com.example.admin.pandatv.view.fragment.livefragment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseFragment;

/**
 * Created by LiYRong on 2017/8/25.
 *
 *          直播
 *
 */
//这是小媛荣的代码
public class Livetelecast_Fragment extends BaseFragment {

    private ImageView live_img;
    private TextView live_title;
    private ImageView live_up;
    private TextView brief;
    private View oneself;
    private TabLayout live_tablayout;
    private ViewPager live_viewpager;

    @Override
    public int getLayout() {
        return R.layout.livetelecast_item;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {

        live_img = view.findViewById(R.id.livetel_img);
        live_title = view.findViewById(R.id.live_title);
        live_up = view.findViewById(R.id.live_up);
        brief = view.findViewById(R.id.brief);
        oneself = view.findViewById(R.id.oneself);

        live_tablayout = view.findViewById(R.id.live_tablayout);
        live_viewpager = view.findViewById(R.id.live_viewpager);


    }
}
