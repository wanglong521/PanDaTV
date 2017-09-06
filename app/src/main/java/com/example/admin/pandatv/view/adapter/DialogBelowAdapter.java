package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.GreenDao_China_Tab;
import com.example.admin.pandatv.model.modelutils.chinalive_greendao.GreenDao_China_TabDao;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.DaoMaster;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.DaoSession;
import com.example.admin.pandatv.view.activity.DialogActivity;
import com.example.admin.pandatv.view.adapter.callbackimpl.Enabledimpl;
import com.example.admin.pandatv.view.adapter.callbackimpl.GetRefreshData;
import com.example.admin.pandatv.view.adapter.callbackimpl.Translateimpl;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/30.
 */

public class DialogBelowAdapter extends RecyclerView.Adapter<DialogBelowAdapter.MyHolder>{
    private GreenDao_China_TabDao dao;
    Context context;
        ArrayList<String> list;
        GetRefreshData getRefreshData;
    Translateimpl translateimpl;
    MyHolder myHolder;
    private int[] location;

    public void getface(GetRefreshData getRefreshData){

        this.getRefreshData = getRefreshData;
    }
    public void getLocation(Translateimpl translateimpl){
            this.translateimpl = translateimpl;
    }
    public DialogBelowAdapter(Context context, ArrayList<String> list) {
            this.context = context;
            this.list = list ;
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "hdm.db", null);
            DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
            DaoSession daoSession = daoMaster.newSession();
            dao = daoSession.getGreenDao_China_TabDao();
        }


    @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_item, null);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyHolder holder, final int position) {
//            if (position == list.size()-1){
//                holder.china_dialog_item_btn.setVisibility(View.GONE);
//            }
            myHolder = holder;
            holder.china_dialog_item_btn.setText(list.get(position));

            if (position == list.size()-1){
                location = new int[2];
                holder.china_dialog_item_btn.getLocationOnScreen(location);
                translateimpl.getCoordinates(location,holder.china_dialog_item_btn,false);
            }

            holder.china_dialog_item_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    GreenDao_China_Tab unique = dao.queryBuilder().where(GreenDao_China_TabDao.Properties.Tabtitle.eq(list.get(position))).build().unique();
                    if (unique.getABoolean()){
                        unique.setABoolean(false);
                        dao.update(unique);
                    }else{
                        dao.delete(unique);
                        unique.setABoolean(true);
                        GreenDao_China_Tab china_tab = new GreenDao_China_Tab(null,unique.getABoolean(),unique.getTabtitle());
                        dao.insert(china_tab);
                    }
                    Toast.makeText(context, list.get(position), Toast.LENGTH_SHORT).show();
                    holder.china_dialog_item_btn.setText("");
                    int[] coordinate = new int[2];
                    holder.china_dialog_item_btn.getLocationOnScreen(coordinate);
                    holder.china_dialog_item_btn.setText("");

                    getRefreshData.getRefreshData(coordinate,holder.china_dialog_item_btn,false);

//                    int[] coordinate = new int[2];
//                    holder.china_dialog_item_btn.getLocationOnScreen(coordinate);
//                    getRefreshData.getRefreshData(list.get(position),coordinate);
//                    TranslateAnimation animation = new TranslateAnimation(coordinate[0],,coordinate[1],);
                }
            });

        }

        @Override
        public int getItemCount() {
            return list==null ? 0 : list.size();
        }


    class MyHolder extends RecyclerView.ViewHolder{

            private final Button china_dialog_item_btn;

            public MyHolder(View itemView) {
                super(itemView);
                china_dialog_item_btn = (Button) itemView.findViewById(R.id.china_dialog_item_btn);
            }
        }
    public void getNotifyData(ArrayList<String> list){
        this.list = list;

    }
}
