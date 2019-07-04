package com.evn.evncpcmobile.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.activity.login.LoginUserActivity;
import com.evn.evncpcmobile.config.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 18-June-2019
 * Time: 10:00
 * Version: 1.0
 */
public class NoLoginActivity extends AppCompatActivity {
    @BindView(R.id.button_login)
    Button button_login;
    @BindView(R.id.ll_guild)
    ConstraintLayout ll_guild;
    @BindView(R.id.ll_register)
    ConstraintLayout ll_register;
    @BindView(R.id.ll_web)
    ConstraintLayout ll_web;
    @BindView(R.id.ll_info)
    ConstraintLayout ll_info;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_login);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoLoginActivity.this, LoginUserActivity.class));
            }
        });
        ll_guild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
         /*       Intent intent = new Intent(NoLoginActivity.this, WebviewActivity.class);
                intent.putExtra(Constants.KEY_SEND_TITLE_WEBVIEW, "Hướng dẫn sử dụng");
                startActivity(intent);*/
            }
        });
        ll_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ll_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ll_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
