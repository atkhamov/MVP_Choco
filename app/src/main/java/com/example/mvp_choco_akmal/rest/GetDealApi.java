package com.example.mvp_choco_akmal.rest;

import com.example.mvp_choco_akmal.entities.DealEntity;
import com.example.mvp_choco_akmal.entities.DealWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDealApi {

    @GET("deals ")
    Call<DealWrapper> getDealList(
            @Query("town_id") int townId,
            @Query("category_id") int categoryId,
            @Query("page") int page
    );
}
