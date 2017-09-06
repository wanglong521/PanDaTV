package com.example.admin.pandatv.view.fragment.livefragment.lfragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.adapter.LookTalkAdapter;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.DaoUtils;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.LookTalkBean;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.LookTalkBeanDao;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseFragment;
import com.example.admin.pandatv.view.view.ClearEditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by LiYRong on 2017/8/26.
 */
public class Lookalittle extends BaseFragment {

    private ClearEditText ed_comment;
    private Button send;
    private ListView look_litview;
    private List<LookTalkBean> looklist = new ArrayList<LookTalkBean>();
    private int FLOOR;
    private String TIME;
    private LookTalkBeanDao getdao;
    private LookTalkAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.lookalittle_item;
    }

    @Override
    protected void initListener() {


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FLOOR=looklist.size();
                if (!ed_comment.getText().toString().trim().equals("")){

                    FLOOR++;
                    String comment = ed_comment.getText().toString().trim();
                    Calendar c = Calendar.getInstance();

                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH) + 1;
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    TIME = month + "-" + day + "-" + year + "";

                    LookTalkBean lookTalkBean = new LookTalkBean();

                    lookTalkBean.setEd_content(comment);

                    lookTalkBean.setFloor(FLOOR);

                    lookTalkBean.setTime(TIME);

                    Log.i("TAG", lookTalkBean.toString());

                    insert(lookTalkBean);
                    App.mBaseActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cha();
                            adapter.notifyDataSetChanged();
                        }
                    });

                    ed_comment.setText("");


                }else {

                    Toast.makeText(getActivity(), "请输入你的评论", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @Override
    protected void initData() {

        cha();

//        LookTalkBean unique = getdao.queryBuilder().where(LookTalkBeanDao.Properties.Floor.eq(looklist)).unique();
//
//        int floor = unique.getFloor();
//
//        FLOOR=FLOOR+floor;

    }

    public void insert(LookTalkBean bean) {
        getdao.insert(bean);
    }

    private void cha() {
        looklist.clear();
        List<LookTalkBean> list = getdao.queryBuilder().build().list();
        looklist.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void initView(View view) {
        getdao = DaoUtils.getDaoUtils(App.mBaseActivity).getdao();
        ed_comment = view.findViewById(R.id.ed_comment);
        send = view.findViewById(R.id.send);
        look_litview = view.findViewById(R.id.look_litview);


        adapter = new LookTalkAdapter(getActivity(), looklist);
        look_litview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}
