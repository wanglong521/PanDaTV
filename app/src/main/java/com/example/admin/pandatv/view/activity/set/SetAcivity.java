package com.example.admin.pandatv.view.activity.set;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseActivity;

/**
 * Created by LiYRong on 2017/9/6.
 */

public class SetAcivity extends BaseActivity{

    private ImageView message_left;
    private ImageView message_right;
    private ImageView message_left1;
    private ImageView message_right1;
    private ImageView delete_img;
    private ImageView mLoginBackwards;
    private TextView delete_text;
    private LinearLayout l_help;
    private LinearLayout l_detection;
    private LinearLayout l_like;
    private LinearLayout l_asregards;

    @Override
    protected void initListener() {

        //点击返回
        mLoginBackwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//点击按个按钮换图片
        message_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message_left1.setVisibility(View.VISIBLE);
                message_left.setVisibility(View.GONE);

            }
        });
        message_left1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message_left.setVisibility(View.VISIBLE);
                message_left1.setVisibility(View.GONE);
            }
        });
        message_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message_right1.setVisibility(View.VISIBLE);
                message_right.setVisibility(View.GONE);

            }
        });
        message_right1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message_right.setVisibility(View.VISIBLE);
                message_right1.setVisibility(View.GONE);
            }
        });


        l_detection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SetAcivity.this, "已经是最新版本了", Toast.LENGTH_SHORT).show();
            }
        });

        l_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SetAcivity.this,HelpActivity.class);

                startActivity(intent);
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        message_left = (ImageView) findViewById(R.id.message_left);
        message_left1 = (ImageView) findViewById(R.id.message_left1);
        message_right = (ImageView) findViewById(R.id.message_right);
        message_right1 = (ImageView) findViewById(R.id.message_right1);
        delete_img = (ImageView) findViewById(R.id.delete_img);
        mLoginBackwards = (ImageView) findViewById(R.id.LoginBackwards);
        delete_text = (TextView) findViewById(R.id.delete_text);
        l_help = (LinearLayout) findViewById(R.id.l_help);
        l_detection = (LinearLayout) findViewById(R.id.l_detection);
        l_like = (LinearLayout) findViewById(R.id.l_like);
        l_asregards = (LinearLayout) findViewById(R.id.l_asregards);


    }

    @Override
    public int getLayoutId() {
        return R.layout.set_item;
    }
}
