package com.example.restclient.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://10.0.2.2:8080/demo/";
    private static RetrofitClient mRetrofitClient;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getmRetrofitClient(){
        if(mRetrofitClient == null){
            mRetrofitClient = new RetrofitClient();
        }
        return mRetrofitClient;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }


}
