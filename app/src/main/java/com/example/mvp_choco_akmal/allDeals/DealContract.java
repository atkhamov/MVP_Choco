package com.example.mvp_choco_akmal.allDeals;

import com.example.mvp_choco_akmal.entities.DealEntity;
import com.example.mvp_choco_akmal.entities.DealWrapper;

import java.util.List;

import retrofit2.Call;

public interface DealContract {

    interface View{
        void showLoading();
        void hideLoading();
        void showDeals(List<DealEntity> listDealEntity);
        void showError(Throwable throwable);
    }

    interface Presenter{
        void load(int page);
    }

    interface Model{
        Call<DealWrapper> getDealList(int page);
    }
}
