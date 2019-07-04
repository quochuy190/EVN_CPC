package com.evn.evncpcmobile.api_service;

import com.evn.evncpcmobile.callback.CallbackData;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @description
 * @authour: $User
 * @createdate $Date
 */
public class ApiServicePost {
    InterfaceApiPost apiService;
    InterfaceApiGetAccessToken apiGetAccessToken;

    public void getApiPostResfull_ALL(final CallbackData<String> callbackData, String sService,
                                      String mData) {
        apiService = InterfaceApiPost.retrofit_restful.create(InterfaceApiPost.class);
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),mData);
        Call<ResponseBody> getApiservice = apiService.getApiServiceRest(sService, requestBody);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                        callbackData.onGetDataSuccess(jsonString);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (Exception e) {
                    callbackData.onGetDataErrorFault(e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }

    public void apiGetAccessToken(final CallbackData<String> callbackData, String sService,
                                  String mData) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("text/plain"),mData);
        apiGetAccessToken = InterfaceApiGetAccessToken.retrofit_get_token.create(InterfaceApiGetAccessToken.class);
        Call<ResponseBody> getApiservice = apiGetAccessToken.getApiServiceRest( requestBody);
        getApiservice.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String jsonString = null;
                JSONObject jobj;
                JSONArray jArray;
                try {
                    if (response.body() != null) {
                        jsonString = response.body().string();
                        callbackData.onGetDataSuccess(jsonString);
                    }
                } catch (IOException e) {
                    callbackData.onGetDataErrorFault(e);
                } catch (Exception e) {
                    callbackData.onGetDataErrorFault(e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callbackData.onGetDataErrorFault(new Exception(t));
            }
        });
    }
}
