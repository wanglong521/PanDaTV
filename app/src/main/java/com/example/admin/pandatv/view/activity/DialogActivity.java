package com.example.admin.pandatv.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.GreenDao_China_Tab;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.GreenDao_China_TabDao;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.DaoMaster;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.DaoSession;
import com.example.admin.pandatv.view.adapter.DialogAdapter;
import com.example.admin.pandatv.view.adapter.DialogBelowAdapter;
import com.example.admin.pandatv.view.adapter.callbackimpl.GetRefreshData;
import com.example.admin.pandatv.view.adapter.callbackimpl.Translateimpl;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static com.umeng.socialize.a.b.d.f;
import static com.umeng.socialize.a.b.d.i;
import static com.umeng.socialize.a.b.d.j;
import static com.umeng.socialize.a.b.d.k;

public class DialogActivity extends Activity implements GetRefreshData,Translateimpl {

    // 这是直播中国弹出的页面

        private ImageView china_dialog_fin;
        private Button china_dialog_base;
        private RecyclerView china_dialog_top_recy;
        private RecyclerView china_dialog_below_recy;
        private ArrayList<String> tabtitle;
        private ArrayList<String> titles;
        private GreenDao_China_TabDao dao;
        private DialogBelowAdapter dialogBelowAdapter;
        private DialogAdapter dialogAdapter;
        int[] toplocation = new int[2];
        int[] belowlocation = new int[2];
        private TranslateAnimation animation;
        private Intent intent;
        private Boolean aBoolean = false;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dialog);
            initView();
            initData();
            initListener();
        }

        private void initData() {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "hdm.db", null);
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
            DaoSession daoSession = daoMaster.newSession();
            dao = daoSession.getGreenDao_China_TabDao();
            intent = getIntent();
            tabtitle = intent.getStringArrayListExtra("tabtitle");
            titles = intent.getStringArrayListExtra("titles");
            for (int i = 0; i < tabtitle.size(); i++) {
                

                for (int j = 0; j < titles.size(); j++) {

                    if (dao.queryBuilder().where(GreenDao_China_TabDao.Properties.Tabtitle.eq(tabtitle.get(i))).build().unique() == null){
                        GreenDao_China_Tab china_tab = new GreenDao_China_Tab(null,true,tabtitle.get(i));
                        dao.insert(china_tab);

                    }

                    }
            }

            for (int k = 0; k < titles.size(); k++) {
                if (dao.queryBuilder().where(GreenDao_China_TabDao.Properties.Tabtitle.eq(titles.get(k))).build().unique() == null){
                    GreenDao_China_Tab china_tab = new GreenDao_China_Tab(null,false,titles.get(k));
                    dao.insert(china_tab);

                }
            }
            tabtitle.clear();
            titles.clear();
            List<GreenDao_China_Tab> list = dao.queryBuilder().list();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getABoolean()){
                    tabtitle.add(list.get(i).getTabtitle());
                }else{
                    titles.add(list.get(i).getTabtitle());
                }
            }
            china_dialog_top_recy.setLayoutManager(new GridLayoutManager(this, 3));
            china_dialog_below_recy.setLayoutManager(new GridLayoutManager(this, 3));
            dialogAdapter = new DialogAdapter(this, tabtitle);
            dialogAdapter.getface(this);
            dialogAdapter.getLocation(this);
            china_dialog_top_recy.setAdapter(dialogAdapter);
            dialogBelowAdapter = new DialogBelowAdapter(this, titles);
            dialogBelowAdapter.getface(this);
            dialogBelowAdapter.getLocation(this);
            china_dialog_below_recy.setAdapter(dialogBelowAdapter);
        }

        private void initView() {
            china_dialog_fin = findViewById(R.id.china_dialog_fin);
            china_dialog_base = findViewById(R.id.china_dialog_base);
            china_dialog_top_recy = findViewById(R.id.china_dialog_top_recy);
            china_dialog_below_recy = findViewById(R.id.china_dialog_below_recy);

            china_dialog_top_recy.setEnabled(false);
            china_dialog_below_recy.setEnabled(false);

            china_dialog_top_recy.setHasFixedSize(true);
            china_dialog_below_recy.setHasFixedSize(true);
        }

        protected void initListener() {
            //   返回图片的监听
            china_dialog_fin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setResult(RESULT_OK,intent);
                    finish();

                }
            });

            //  编辑按钮的监听
            china_dialog_base.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (aBoolean) {
                        china_dialog_top_recy.setEnabled(false);
                        china_dialog_below_recy.setEnabled(false);
                        china_dialog_base.setText("编辑");
                        aBoolean = false;

                    } else {
                        china_dialog_top_recy.setEnabled(true);
                        china_dialog_below_recy.setEnabled(true);
                        china_dialog_base.setText("完成");
                        aBoolean = true;

                    }
                }
            });
        }

        @Override
        public void getRefreshData(int[] coordinate ,View view,Boolean aBoolean) {
//        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "hdm.db", null);
//        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
//        DaoSession daoSession = daoMaster.newSession();
//        GreenDao_China_TabDao dao = daoSession.getGreenDao_China_TabDao();
            if (aBoolean){
                View childAt =  china_dialog_below_recy.getLayoutManager().getChildAt(titles.size() - 1);
//                belowlocation[0] = childAt.getLeft();
//                belowlocation[1] = childAt.getTop();
                childAt.getLocationOnScreen(belowlocation);
                animation = new TranslateAnimation(coordinate[0],
                        belowlocation[0],coordinate[1],belowlocation[1]);

            }else{
                View childAt =  china_dialog_top_recy.getLayoutManager().getChildAt(tabtitle.size() - 1);
//                toplocation[0] = childAt.getLeft();
//                toplocation[1] = childAt.getTop();
                childAt.getLocationOnScreen(toplocation);
                animation = new TranslateAnimation(coordinate[0],
                        toplocation[0],coordinate[1],toplocation[1]);
            }
            Log.e( "3333333333333333333: ", coordinate[0]+"aaa"+ coordinate[1]+"bbb"+belowlocation[0]
            + "ccc" + belowlocation[1]);
            animation.setDuration(500);
            view.setAnimation(animation);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            titles.clear();
                            tabtitle.clear();
                            List<GreenDao_China_Tab> list = dao.queryBuilder().list();
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getABoolean()){
                                    tabtitle.add(list.get(i).getTabtitle());
                                }else{
                                    titles.add(list.get(i).getTabtitle());
                                }
                            }
//                dialogAdapter.getNotifyData(tabtitle);
//                dialogBelowAdapter.getNotifyData(titles);
                            dialogAdapter.notifyDataSetChanged();
                            dialogBelowAdapter.notifyDataSetChanged();
                        }
                    });
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });


//        DialogAdapter dialogAdapter = new DialogAdapter(this, tabtitle);
//        china_dialog_top_recy.setAdapter(dialogAdapter);
//        DialogBelowAdapter dialogBelowAdapter = new DialogBelowAdapter(this, titles);
//        china_dialog_below_recy.setAdapter(dialogBelowAdapter);
        }

        @Override
        public void getCoordinates(int[] location,View view,Boolean aBoolean) {
//        view.setVisibility(View.VISIBLE);
            if (aBoolean){
                toplocation = location;
            }else{
                belowlocation = location;
            }
        }

//    @Override
//    public void getRefreshData(String string, int[] coordinate) {
//        Log.e("getRefreshData: ", titles.size()+"");
//        Boolean aBoolean = true;
//        for (int i = 0; i < titles.size(); i++) {
//            if (titles.get(i).equals(string)) {
//                titles.remove(i);
//                aBoolean = true;
//                china_dialog_below_recy.setAdapter(new DialogAdapter(this, titles));
//            }
//
//        }
//        for (int i = 0; i < tabtitle.size(); i++) {
//            if (tabtitle.get(i).equals(string)) {
//                tabtitle.remove(i);
//                aBoolean = true;
//                china_dialog_below_recy.setAdapter(new DialogAdapter(this, tabtitle));
//            }
//
//        }
//    }
    }
