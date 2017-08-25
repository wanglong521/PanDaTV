package com.example.admin.pandatv.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.fragment.livefragment.Livetelecast_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.PandaFiles_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.PandaTOP_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Pandathing_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Primarynew_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Special_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Splendid_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.Supersprout_Fragment;
import com.example.admin.pandatv.view.fragment.livefragment.WhenBear_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/8/23.
 */

public class LiveModule_Fragment  extends BaseFragment {

    private ImageView my;

    private ViewPager mViewPager;
    private List<Fragment> fraglist=new ArrayList<Fragment>();
    private List<String> titlelist=new ArrayList<String>();
    private TabLayout mTablayout;


    @Override
    public int getLayout() {
        return R.layout.livemodule_fragment;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initView(View view) {

        my = view.findViewById(R.id.my);

        mTablayout = view.findViewById(R.id.mTableyout);


        mViewPager = view.findViewById(R.id.mViewPager);


        titlelist.add("直播");
        titlelist.add("精彩一刻");
        titlelist.add("当熊不让");
        titlelist.add("超萌滚滚秀");
        titlelist.add("熊猫档案");
        titlelist.add("熊猫TOP榜");
        titlelist.add("熊猫那些事");
        titlelist.add("特别节目");
        titlelist.add("原创新闻");


        fraglist.add(new Livetelecast_Fragment());
        fraglist.add(new Splendid_Fragment());
        fraglist.add(new WhenBear_Fragment());
        fraglist.add(new Supersprout_Fragment());
        fraglist.add(new PandaFiles_Fragment());
        fraglist.add(new PandaTOP_Fragment());
        fraglist.add(new Pandathing_Fragment());
        fraglist.add(new Special_Fragment());
        fraglist.add(new Primarynew_Fragment());




        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(0)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(1)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(2)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(3)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(4)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(5)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(6)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(7)));
        mTablayout.addTab(mTablayout.newTab().setText(titlelist.get(8)));

        FragmentManager manager = getActivity().getSupportFragmentManager();

        /**
         * 这个方法是设置viewpager不能左右滑动
         */
        mViewPager .setOnTouchListener( new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;  //修改为true
            }

        });


        MyAdapter adapter=new MyAdapter(manager);

        mViewPager.setAdapter(adapter);

        mTablayout.setupWithViewPager(mViewPager);




    }

    public  class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override//返回对应位置的
        public Fragment getItem(int position) {

            return fraglist.get(position);
        }

        @Override//赶回viewpage总条目数
        public int getCount() {

            return fraglist.size();
        }

        @Override
        //给TabLayout加标题与TabLayout起使用
        public CharSequence getPageTitle(int position)
        {
            return titlelist.get(position);
        }
    }

}
