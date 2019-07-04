package com.evn.evncpcmobile.activity.login;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.evn.evncpcmobile.R;
import com.evn.evncpcmobile.base.BaseActivity;

import butterknife.BindView;


/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 18-June-2019
 * Time: 16:38
 * Version: 1.0
 */
public class LoginOtpActivity extends BaseActivity {
    @BindView(R.id.ll_insert_otp)
    ConstraintLayout ll_insert_otp;
    @BindView(R.id.btn_login)
    Button btn_login;
    @BindView(R.id.btn_comfirm_otp)
    Button btn_comfirm_otp;
    @BindView(R.id.btn_back)
    ImageView btn_back;
    @BindView(R.id.edtPhone)
    EditText edtPhone;
    @BindView(R.id.edt_number_otp)
    EditText edt_number_otp;


    @Override
    public int setContentViewId() {
        return R.layout.activity_login_otp;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initEvent();

    }



    private void initEvent() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ll_insert_otp.setVisibility(View.VISIBLE);
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
