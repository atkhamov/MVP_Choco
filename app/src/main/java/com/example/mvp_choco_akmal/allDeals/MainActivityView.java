package com.example.mvp_choco_akmal.allDeals;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp_choco_akmal.R;
import com.example.mvp_choco_akmal.adapter.DealAdapter;
import com.example.mvp_choco_akmal.adapter.ReachEndListener;
import com.example.mvp_choco_akmal.allDeals.DealContract;
import com.example.mvp_choco_akmal.allDeals.DealPresenter;
import com.example.mvp_choco_akmal.entities.DealEntity;
import com.example.mvp_choco_akmal.entities.DealWrapper;
import com.example.mvp_choco_akmal.rest.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityView extends AppCompatActivity implements DealContract.View, ReachEndListener {

    //region Vars
    /**These variables are taken from DealView class. But I have deleted DealView, because
     * not the role of DealView is played by MainActivityView*/
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private DealAdapter dealAdapter;
    private DealContract.Presenter dealPresenter;
    /**End of segment from DealView Class*/
    //endregion

    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView();
        progressBar = findViewById(R.id.progressBar);
        /**Why in the following statement operator 'this' worked well,
         * it is because we implemented DealContract.View*/
        dealPresenter = new DealPresenter(this);
        dealPresenter.load(1);
    }

    /**The following is the method for adjusting the recyclerView and adapter.
     * The purpose of doing so is to have everything related to recyclerView to be
     * in one place.
     * In the 'OnCreate()' method we just call this method 'setUpRecyclerView'*/
    private void setUpRecyclerView(){
        recyclerView = findViewById(R.id.rvDeals);
        dealAdapter = new DealAdapter();

        /**Here we will create LayoutManager in order to set up the elements\
         * within the layout*/
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        /**Now we need to set up the Adapter on to the RecyclerView*/
        recyclerView.setAdapter(dealAdapter);

        dealAdapter.setReachEndListener(this);
    }



    //region Overriden methods
    /**These Overriden methods are taken from DealView class. But I have deleted DealView, because
     * not the role of DealView is played by MainActivityView*/
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
        Toast.makeText(getBaseContext(), "Error" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onReachEnd() {
        page++;
        dealPresenter.load(page);
    }
    /**End of segment from DealView Class*/
    //endregion
}
