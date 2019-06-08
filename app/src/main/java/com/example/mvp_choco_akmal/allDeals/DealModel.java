package com.example.mvp_choco_akmal.allDeals;

import com.example.mvp_choco_akmal.entities.DealWrapper;
import com.example.mvp_choco_akmal.rest.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealModel implements DealContract.Model {

    DealContract.Presenter presenter;
    public DealModel(DealContract.Presenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void getDealList(int page) {
        Call<DealWrapper> call = NetworkService
                .getInstance()
                .getDealApi()
                .getDealList(1,1, page);
        call.enqueue(new Callback<DealWrapper>() {
            @Override
            public void onResponse(Call<DealWrapper> call, Response<DealWrapper> response) {
                presenter.loadingFinished(response.body());
            }

            @Override
            public void onFailure(Call<DealWrapper> call, Throwable t) {
                presenter.loadingFailed(t);
            }
        });
    }
}
