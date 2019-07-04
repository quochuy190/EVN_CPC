package com.evn.evncpcmobile.api_service;


import com.evn.evncpcmobile.config.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by QQ on 7/4/2017.
 */

public interface InterfaceApiPost<T> {
    // @FormUrlEncoded
    @POST("/n1/{service}")
    @Headers("Content-Type: application/json")
    Call<ResponseBody> getApiServiceRest(
            @Path("service") String service,
            @Body RequestBody jsonObject);

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
    Retrofit retrofit_restful = new Retrofit.Builder()
            .baseUrl(Config.BASE_URL_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build();

}

