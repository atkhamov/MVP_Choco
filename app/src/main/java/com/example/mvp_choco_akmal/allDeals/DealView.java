package com.example.mvp_choco_akmal.allDeals;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvp_choco_akmal.adapter.DealAdapter;
import com.example.mvp_choco_akmal.entities.DealEntity;

import java.util.List;

public class DealView implements DealContract.View {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private DealAdapter dealAdapter;

    private DealContract.Presenter dealPresenter;

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDeals(List<DealEntity> listDealEntity) {
        dealAdapter.addDealEntityList(listDealEntity);
    }

    @Override
    public void showError(Throwable throwable) {

    }
}
