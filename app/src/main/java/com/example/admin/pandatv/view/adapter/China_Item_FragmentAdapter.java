package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.entity.LvieItemBean;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/28.
 */

public class China_Item_FragmentAdapter extends RecyclerView.Adapter<China_Item_FragmentAdapter.MyHolder>{
    Context context;
    ArrayList<LvieItemBean> list;
        public China_Item_FragmentAdapter(Context context, ArrayList<LvieItemBean> list) {
            this.context = context;
            this.list = list ;

        }


        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.china_fragment_item, null);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyHolder holder, int position) {

            holder.china_item_brief.setText(list.get(position).getBrief());
            holder.china_item_title.setText(list.get(position).getTitle());
            Glide.with(context).load(list.get(position).getImage()).placeholder(R.drawable._no_img).error(R.drawable._no_img).into(holder.china_item_image);
            holder.china_item_updele.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (holder.china_item_brief.getVisibility() == View.VISIBLE){
                            holder.china_item_brief.setVisibility(View.GONE);
                        holder.china_item_updele.setImageResource(R.drawable.live_down);
                    }else{
                        holder.china_item_brief.setVisibility(View.VISIBLE);
                        holder.china_item_updele.setImageResource(R.drawable.live_up);
                    }

                }
            });

        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{

            private final TextView china_item_brief;
            private final TextView china_item_title;
            private final ImageView china_item_updele;
            private final ImageView china_item_image;

            public MyHolder(View itemView) {
                super(itemView);
                china_item_brief = (TextView) itemView.findViewById(R.id.china_item_brief);
                china_item_title = (TextView) itemView.findViewById(R.id.china_item_title);
                china_item_updele = (ImageView) itemView.findViewById(R.id.china_item_updele);
                china_item_image = (ImageView) itemView.findViewById(R.id.china_item_image);
            }
        }
}
