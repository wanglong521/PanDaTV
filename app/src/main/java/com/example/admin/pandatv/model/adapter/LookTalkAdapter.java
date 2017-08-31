package com.example.admin.pandatv.model.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.modelutils.pandalive_greendao.LookTalkBean;

import java.util.List;

/**
 * Created by LiYRong on 2017/8/31.
 */

public class LookTalkAdapter extends BaseAdapter{
    private Context context;
    private List<LookTalkBean> list;
    private ViewHolder holder;

    public LookTalkAdapter(Context context, List<LookTalkBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        if (view == null) {

            holder = new ViewHolder();

            view = View.inflate(context, R.layout.looklist_item, null);

            holder.ed_content = view.findViewById(R.id.ed_content);

            holder.ed_time=view.findViewById(R.id.ed_time);

            holder.floor=view.findViewById(R.id.floor);

            view.setTag(holder);
        }else {

            holder = (ViewHolder) view.getTag();
        }

        holder.ed_content.setText(list.get(i).getEd_content());
        holder.ed_time.setText(list.get(i).getTime());
        holder.floor.setText(list.get(i).getFloor()+"楼");

        return view;
    }
    static class ViewHolder{

        TextView ed_content,floor,ed_time;

    }
}
