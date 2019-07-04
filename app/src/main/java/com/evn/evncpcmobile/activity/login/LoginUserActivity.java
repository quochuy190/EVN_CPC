package com.evn.evncpcmobile.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.evn.evncpcmobile.BuildConfig;
import com.evn.evncpcmobile.MainActivity;
import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.models.request_api.GetAccessToken_Request;
import com.evn.evncpcmobile.models.request_api.Init_Request;
import com.evn.evncpcmobile.models.response_api.Init_Response;
import com.evn.evncpcmobile.presenter.InterfaceLogin;
import com.evn.evncpcmobile.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;



/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 18-June-2019
 * Time: 10:00
 * Version: 1.0
 */
public class LoginUserActivity extends AppCompatActivity implements View.OnClickListener, InterfaceLogin.View {
    @BindView(R.id.img_back)
    ImageView img_back;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.btn_login_phone)
    Button btn_login_phone;
    String UUID;
    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
        initEvent();
        initData();
    }

    private void initEvent() {
        img_back.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        btn_login_phone.setOnClickListener(this);
    }

    private void initData() {
        UUID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Init_Request objRequest = new Init_Request(BuildConfig.VERSION_NAME, android.os.Build.BRAND + " "
                + android.os.Build.MODEL,
                "android", android.os.Build.VERSION.RELEASE, "test", UUID);
        GetAccessToken_Request objGetToken = new GetAccessToken_Request("123", "532", "");
        mPresenter.api_init(objRequest);
        mPresenter.api_get_access_token(objGetToken);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.btn_login:
                startActivity(new Intent(LoginUserActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.btn_login_phone:
                startActivity(new Intent(LoginUserActivity.this, LoginOtpActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void show_error_api() {

    }

    @Override
    public void api_show_init(Init_Response mResponse) {

    }
}
