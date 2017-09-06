package com.example.admin.pandatv.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.pandatv.R;
import com.example.admin.pandatv.model.OkHttpClientManager;
import com.example.admin.pandatv.model.bean.LiveShow;
import com.example.admin.pandatv.model.entity.ChinaAck;
import com.example.admin.pandatv.model.entity.LvieItemBean;
import com.example.admin.pandatv.view.activity.banderavtivitys.FristActivity;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.UrlUtils;
import com.google.gson.Gson;
import com.yixia.weibo.sdk.VCamera;
import com.yixia.weibo.sdk.util.DeviceUtils;

import java.io.IOException;
import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.admin.pandatv.R.id.vitamio_viedoview;

/**
 * Created by lenovo on 2017/8/28.
 */

public class China_Item_FragmentAdapter extends RecyclerView.Adapter<China_Item_FragmentAdapter.MyHolder> implements MediaPlayer.OnPreparedListener {
    Context context;
    ArrayList<LvieItemBean> list;
    MyHolder myHolder;
    private ChinaAck chinaAck;
    private String hls2;

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
            myHolder = holder;
            Vitamio.isInitialized(context);
            holder.china_item_brief.setText(list.get(position).getBrief());
            holder.china_item_title.setText(list.get(position).getTitle());
//            holder.china_item_video.setUp("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/09/04/3138164066cf49ad88b8a236545996fb_h2642000000nero_aac16-1.mp4",
//                    "");

            holder.china_item_video.setUp(list.get(position).getId(),
                    "");
            JCVideoPlayer.setThumbImageViewScalType(ImageView.ScaleType.FIT_XY);
            Glide.with(context).load(list.get(position).getImage()).placeholder(R.drawable._no_img).error(R.drawable._no_img).into(holder.china_item_video.ivThumb);
            holder.china_item_updele.setOnClickListener( new View.OnClickListener() {
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

    @Override
    public void onPrepared(MediaPlayer mp) {
    }

    class MyHolder extends RecyclerView.ViewHolder{

            private final TextView china_item_brief;
            private final TextView china_item_title;
            private final ImageView china_item_updele;
            private final JCVideoPlayer china_item_video;

            public MyHolder(View itemView) {
                super(itemView);
                china_item_brief = (TextView) itemView.findViewById(R.id.china_item_brief);
                china_item_title = (TextView) itemView.findViewById(R.id.china_item_title);
                china_item_updele = (ImageView) itemView.findViewById(R.id.china_item_updele);
                china_item_video = (JCVideoPlayer) itemView.findViewById(R.id.china_item_video);
            }
        }
        public void notifyChanged(ArrayList<LvieItemBean> list){
                this.list = list;
            notifyDataSetChanged();
        }


}
