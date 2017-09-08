package com.example.admin.pandatv.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.activity.set.SetAcivity;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;

/**
 * 个人中心
 */
public class PersonalCenter extends BaseActivity {


    private LinearLayout personalLogin;
    private LinearLayout personalWatchhistory;
    private LinearLayout personalmycollection;
    private LinearLayout personalSetup;

    @Override
    protected void initListener() {
        findViewById(R.id.PersonalBackwards).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.mBaseActivity.finish();
            }
        });
        personalLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(App.mBaseActivity, LoginActivity.class);
                startActivityForResult(intent, 1001);
            }
        });

        personalSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(PersonalCenter.this, SetAcivity.class);

                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1001:
                break;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        personalLogin = (LinearLayout) findViewById(R.id.PersonalLogin);
        personalWatchhistory = (LinearLayout) findViewById(R.id.PersonalWatchhistory);
        personalmycollection = (LinearLayout) findViewById(R.id.Personalmycollection);
        personalSetup = (LinearLayout) findViewById(R.id.PersonalSetup);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_personal_center;
    }
}
