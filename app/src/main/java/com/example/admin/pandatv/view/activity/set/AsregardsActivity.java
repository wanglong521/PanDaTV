package com.example.admin.pandatv.view.activity.set;

import android.view.View;
import android.widget.ImageView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.BaseActivity;

/**
 * Created by LiYRong on 2017/9/7.
 */

public class AsregardsActivity extends BaseActivity{

    private ImageView mLoginBackwards;

    @Override
    protected void initListener() {

        mLoginBackwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        mLoginBackwards = (ImageView) findViewById(R.id.LoginBackwards);

    }

    @Override
    public int getLayoutId() {
        return R.layout.asregards;
    }
}
