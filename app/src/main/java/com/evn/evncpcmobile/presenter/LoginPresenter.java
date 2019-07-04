package com.evn.evncpcmobile.presenter;

import android.util.Log;

import com.evn.evncpcmobile.api_service.ApiServicePost;
import com.evn.evncpcmobile.callback.CallbackData;
import com.evn.evncpcmobile.models.request_api.GetAccessToken_Request;
import com.evn.evncpcmobile.models.request_api.Init_Request;
import com.evn.evncpcmobile.presenter.InterfaceLogin;
import com.google.gson.Gson;


/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 02-July-2019
 * Time: 15:12
 * Version: 1.0
 */
public class LoginPresenter implements InterfaceLogin.Presenter {
    private static final String TAG = "LoginPresenter";
    ApiServicePost apiServicePost;
    InterfaceLogin.View mView;

    public LoginPresenter(InterfaceLogin.View mView) {
        apiServicePost = new ApiServicePost();
        this.mView = mView;
    }

    @Override
    public void api_init(Init_Request sBody) {
        String sService = "init";
        Gson json = new Gson();// chúng ta dùng thư viện Gson để chuyển đối tượng sang json
        String mBody = json.toJson(sBody);//return sang một string, có định dạng json.
        apiServicePost.getApiPostResfull_ALL(new CallbackData<String>() {
            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
            }

            @Override
            public void onGetDataErrorFault(Exception e) {
                Log.e(TAG, "onGetDataErrorFault: " + e);
            }
        }, sService, mBody);
    }

    @Override
    public void api_get_access_token(GetAccessToken_Request sBody) {
        String sService = "init";
        Gson json = new Gson();// chúng ta dùng thư viện Gson để chuyển đối tượng sang json
        String mBody = json.toJson(sBody);//return sang một string, có định dạng json.
        apiServicePost.apiGetAccessToken(new CallbackData<String>() {
            @Override
            public void onGetDataSuccess(String objT) {
                Log.i(TAG, "onGetDataSuccess: " + objT);
            }

            @Override
            public void onGetDataErrorFault(Exception e) {
                Log.e(TAG, "onGetDataErrorFault: " + e);
            }
        }, sService, mBody);
    }

    @Override
    public void api_register(String sBody) {

    }

    @Override
    public void api_update_device(String sBody) {

    }
}
