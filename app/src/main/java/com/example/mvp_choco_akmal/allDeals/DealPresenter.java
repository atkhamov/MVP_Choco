package com.example.mvp_choco_akmal.allDeals;

import com.example.mvp_choco_akmal.entities.DealWrapper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DealPresenter implements DealContract.Presenter {

    private DealContract.Model model;
    private DealContract.View view;


    /**We need Constructor in order to transfer what Model and View we have*/
    public DealPresenter(DealContract.View view) {
        this.model = new DealModel();
        this.view = view;
    }

    @Override
    public void load(int page) {
        Call<DealWrapper> call = model.getDealList(page);
        call.enqueue(new Callback<DealWrapper>() {
            @Override
            public void onResponse(Call<DealWrapper> call, Response<DealWrapper> response) {
                view.hideLoading();
                view.showDeals(response.body().getDealEntityList());
            }

            @Override
            public void onFailure(Call<DealWrapper> call, Throwable t) {
                view.hideLoading();
                view.showError(t);
            }
        });
    }

}
