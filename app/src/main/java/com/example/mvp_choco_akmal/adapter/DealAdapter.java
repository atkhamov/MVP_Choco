package com.example.mvp_choco_akmal.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp_choco_akmal.R;
import com.example.mvp_choco_akmal.entities.DealEntity;

import java.util.ArrayList;
import java.util.List;

public class DealAdapter extends RecyclerView.Adapter<DealViewHolder> {

    private View view;
    private DealViewHolder dealViewHolder;
    private List<DealEntity> dealEntityList;
    private ReachEndListener reachEndListener;

    public List<DealEntity> getDealEntityList(){
        return dealEntityList;
    }

    public void setReachEndListener(ReachEndListener reachEndListener){
        this.reachEndListener = reachEndListener;
    }

    public DealAdapter(){
        this.dealEntityList = new ArrayList<>();
    }

    public void setDealEntityList(List<DealEntity> dealEntityList){   /**Why do we create a new dealEntityList? ABOVE WE HAVE CREATED one already*/
        this.dealEntityList.clear();
        this.dealEntityList.addAll(dealEntityList);
        notifyDataSetChanged();
    }

    public void addDealEntityList(List<DealEntity> dealEntityList){    /**Why do we have addDealEntityList() while we have setDealEntityList()?*/
        this.dealEntityList.addAll(dealEntityList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DealViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new DealViewHolder(view);   /**Is it RECURSION?*/
    }

    @Override
    public void onBindViewHolder(@NonNull DealViewHolder dealViewHolder, int position) {
        dealViewHolder.bind(dealEntityList.get(position));

        /**In order to avoid NullPointerException we create the following condition*/
        if(position >= dealEntityList.size() - 3){
            if(reachEndListener != null){
                reachEndListener.onReachEnd();
            }
        }
    }

    @Override
    public int getItemCount() {
        return dealEntityList.size();
    }
}
