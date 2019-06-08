package com.example.mvp_choco_akmal.allDeals;

import com.example.mvp_choco_akmal.entities.DealWrapper;

public class DealPresenter implements DealContract.Presenter {

    private DealContract.Model model;
    private DealContract.View view;


    /**We need Constructor in order to transfer what Model and View we have*/
    public DealPresenter(DealContract.View view) {
        this.model = new DealModel(this);
        this.view = view;
    }

    @Override
    public void load(int page) {
        model.getDealList(page);
    }

    @Override
    public void loadingFinished(DealWrapper dealWrapper) {
        view.showDeals(dealWrapper.getDealEntityList());
    }

    @Override
    public void loadingFailed(Throwable throwable) {
        view.hideLoading();
        view.showError(throwable);
    }
}
