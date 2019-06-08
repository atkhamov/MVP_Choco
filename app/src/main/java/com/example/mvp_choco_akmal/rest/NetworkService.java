package com.example.mvp_choco_akmal.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService networkService = new NetworkService();

    private Retrofit mRetrofit;

    private NetworkService(){
        //Later, we will add Retrofit elements
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://chocolife.me/mobileapi/v3_3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**The following statement creates the getInstance() method
     * in order to enable other classes to use this Class.
     * Otherwise, it will not be possible to get instance of this class.
     * Because, this is a SingleTone class and we can not create the object
     * of this class in other classes*/
    public static NetworkService getInstance(){
        return networkService;
    }

    public GetDealApi getDealApi(){
        return mRetrofit.create(GetDealApi.class);
    }

}
