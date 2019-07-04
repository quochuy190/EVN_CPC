package com.evn.evncpcmobile.api_service;


import com.evn.evncpcmobile.config.Config;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by QQ on 7/4/2017.
 */

public interface InterfaceApiGetAccessToken {
    // @FormUrlEncoded
    @Headers("Content-Type: application/json")
    @POST("/getAccessToken")
    Call<ResponseBody> getApiServiceRest(@Body RequestBody jsonObject);

    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();

            Request.Builder builder = originalRequest.newBuilder()
                    .header("Authorization", Config.KEY_AUTHORIZATION);
            Request newRequest = builder
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();

    Retrofit retrofit_get_token = new Retrofit.Builder()
            .baseUrl(Config.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

}
