package com.example.mvp_choco_akmal.allDeals;

import com.example.mvp_choco_akmal.entities.DealWrapper;
import com.example.mvp_choco_akmal.rest.NetworkService;

import retrofit2.Call;

public class DealModel implements DealContract.Model {


    @Override
    public Call<DealWrapper> getDealList(int page) {
        return NetworkService
                .getInstance()
                .getDealApi()
                .getDealList(1,1, page);
    }
}
