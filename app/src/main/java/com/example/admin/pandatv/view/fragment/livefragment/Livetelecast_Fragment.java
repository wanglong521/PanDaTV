package com.example.admin.pandatv.view.fragment.livefragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.livapandabean.LiveMBean;
import com.example.admin.pandatv.prosenter.livepandaimpl.IPresenterImplLivemBean;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.base.LiveMBeanView;
import com.example.admin.pandatv.view.fragment.livefragment.lfragment.Lookalittle;
import com.example.admin.pandatv.view.fragment.livefragment.lfragment.MoreLiveFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiYRong on 2017/8/25.
 *
 *          直播
 *
 */
//这是小媛荣的代码

// TODO: 2017/8/27 这里有一个很严重的问题,就是tablayout的名字会加载两遍
public class Livetelecast_Fragment extends BaseFragment implements LiveMBeanView{

    private ImageView live_img;
    private TextView live_title;
    private ImageView live_up;
    private TextView brief;
    private View oneself;
    private  TabLayout live_tablayout;
    private ViewPager live_viewpager;
    private List<LiveMBean> liveMBeen=new ArrayList<LiveMBean>();
    private int NUM=1;
    private List<String> tabnamelist;
    private List<Fragment> fragmentlist=new ArrayList<Fragment>();

    @Override
    public int getLayout() {
        return R.layout.livetelecast_item;
    }

    @Override
    protected void initListener() {

        live_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NUM == 1) {
                    brief.setVisibility(View.VISIBLE);
                    oneself.setVisibility(View.VISIBLE);
                    live_up.setImageResource(R.drawable.live_up);
                     NUM++;
                }else{
                    brief.setVisibility(View.GONE);
                    oneself.setVisibility(View.GONE);
                    live_up.setImageResource(R.drawable.live_down);
                    NUM--;
                }

            }
        });

        fragmentlist.clear();
        fragmentlist.add(new MoreLiveFragment());
        fragmentlist.add(new Lookalittle());


    }





    @Override
    protected void initData() {
        tabnamelist=new ArrayList<>();
        IPresenterImplLivemBean iPresenterImplLivemBean=new IPresenterImplLivemBean(this);
        iPresenterImplLivemBean.Getcontroller();
        live_tablayout.setupWithViewPager(live_viewpager);


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

    @Override
    public void OnSucceed(LiveMBean succed) {

      liveMBeen.add(succed);

        tabnamelist.clear();

            for (LiveMBean item :
                    liveMBeen) {
                List<LiveMBean.LiveBean> live = item.getLive();

            LiveMBean.BookmarkBean bookmark = item.getBookmark();



                List<LiveMBean.BookmarkBean.MultipleBean> multiple = bookmark.getMultiple();
                for (LiveMBean.BookmarkBean.MultipleBean multipleBean :
                        multiple) {

                    tabnamelist.add(multipleBean.getTitle());

                }

                List<LiveMBean.BookmarkBean.WatchTalkBean> watchTalk = bookmark.getWatchTalk();

                for (LiveMBean.BookmarkBean.WatchTalkBean watchTalkBean :
                        watchTalk) {

                    tabnamelist.add(watchTalkBean.getTitle());

                }


            for (LiveMBean.LiveBean bean:
            live){

                Glide.with(getActivity()).load(bean.getImage()).into(live_img);

                live_title.setText(bean.getTitle());

                brief.setText(bean.getBrief());


            }

        }

        live_tablayout.addTab(live_tablayout.newTab().setText(tabnamelist.get(0)));
        live_tablayout.addTab(live_tablayout.newTab().setText(tabnamelist.get(1)));



        FragmentManager manager = getActivity().getSupportFragmentManager();

        MyliveAdapter adapter=new MyliveAdapter(manager);

        live_viewpager.setAdapter(adapter);



    }

    @Override
    public void OnDefeated() {

        Log.e("TAG","请求失败");

    }

    public  class MyliveAdapter extends FragmentPagerAdapter {

        public MyliveAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override//返回对应位置的
        public Fragment getItem(int position) {

            return fragmentlist.get(position);
        }

        @Override//赶回viewpage总条目数
        public int getCount() {

            return fragmentlist.size();
        }

        @Override
        //给TabLayout加标题   与TabLayout起使用
        public CharSequence getPageTitle(int position)
        {
            return tabnamelist.get(position);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
