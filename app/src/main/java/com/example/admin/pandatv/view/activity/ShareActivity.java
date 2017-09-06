package com.example.admin.pandatv.view.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.admin.pandatv.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class ShareActivity extends AppCompatActivity implements View.OnClickListener {


    CallbackManager callbackManager;
    ShareDialog shareDialog;
    private ImageView share_qq;
    private ImageView share_delete;
    private ImageView share_facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_share);
        initView();
    }

    private void initView() {

        share_qq = (ImageView) findViewById(R.id.share_qq);
        share_delete = (ImageView) findViewById(R.id.share_delete);
        share_facebook = (ImageView) findViewById(R.id.share_facebook);

        share_qq.setOnClickListener(this);
        share_delete.setOnClickListener(this);
        share_facebook.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.share_qq:
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "哈哈哈");
                //这里是发送的内容
                intent.putExtra(Intent.EXTRA_TEXT, "http://124.236.96.43/vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/08/31/e6c80dae83884dc3a18bbf279b1815b0_h264818000nero_aac32-1.mp4?wshc_tag=0&wsts_tag=59aca93f&wsid_tag=73ab8029&wsiphost=ipdbm");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setComponent(new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity"));
                //若是分享到QQ，可将包名改为com.tencent.mobileqq，分享页面名改为com.tencent.mobileqq.activity.JumpActivity
                final Context context = ShareActivity.this;
                context.startActivity(intent);

                break;
            case R.id.share_facebook:
//               这是以下是如何触发分享的示例：
               /* final ShareFBProvider shareFBProvider = ShareFBProvider.getInstance();
                Utils.share(ShareActivity.this, new Utils.IShareCallback() {
                    @Override
                    public void onShareSuccess(String source) {

                        shareFBProvider.handleShareResult(shareFBProvider.SHARE_OK);
                        finish();

                    }

                    @Override
                    public void onShareFail() {
                        shareFBProvider.handleShareResult(shareFBProvider.SHARE_CANCEL);
                        Toast.makeText(ShareActivity.this, "你没有facebook", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onShareCancel() {

                        shareFBProvider.handleShareResult(-1);
                        finish();

                    }
                });*/

                callbackManager = CallbackManager.Factory.create();
                shareDialog = new ShareDialog(this);
                // this part is optional
                shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
                    @Override
                    public void onSuccess(Sharer.Result result) {

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
                if (ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                            .build();
                    shareDialog.show(linkContent);
                }else {

                    Toast.makeText(this, "你没有facebook", Toast.LENGTH_SHORT).show();
                }

                ShareLinkContent content = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com"))
                        .build();
                ShareDialog.show(this, content);

                break;
            case R.id.share_delete:

                finish();
                break;

        }
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
