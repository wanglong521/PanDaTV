package com.example.admin.pandatv.view.activity;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.admin.pandatv.R;
import com.example.admin.pandatv.view.base.App;
import com.example.admin.pandatv.view.base.BaseActivity;
import com.umeng.qq.tencent.Tencent;

/**
 * 登陆
 */
public class LoginActivity extends BaseActivity {

    private ImageView loginBackwards;
    private TextView LoginRegistered;
    private RadioGroup LoginRadioGroup;
    private EditText LoginNumber;
    private EditText LoginPassword;
    private Button LoginButton;
    private TextView ForgetPassword;
    private Tencent mTencent;

    @Override
    protected void initListener() {
        LoginRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i){
                    case R.id.LoginWX:
                        break;
                    case R.id.LoginQQ:


                        break;
                    case R.id.LoginXL:
                        break;
                }
            }
        });
        loginBackwards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                App.mBaseActivity.finish();
            }
        });
        LoginRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(App.mBaseActivity,RegisteredActivity.class);
                startActivityForResult(intent,1100);
            }
        });
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        ForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(App.mBaseActivity,ForgetPasswordActivity.class);
                startActivityForResult(intent,1200);
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        loginBackwards = (ImageView) findViewById(R.id.LoginBackwards);
        LoginRegistered = (TextView) findViewById(R.id.LoginRegistered);
        LoginRadioGroup = (RadioGroup) findViewById(R.id.LoginRadioGroup);
        LoginNumber = (EditText) findViewById(R.id.LoginNumber);
        LoginPassword = (EditText) findViewById(R.id.LoginPassword);
        LoginButton = (Button) findViewById(R.id.LoginButton);
        ForgetPassword = (TextView) findViewById(R.id.ForgetPassword);
        mTencent = Tencent.createInstance("222222", getApplicationContext());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1100:
                break;
            case 1200:
                break;
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }



}
