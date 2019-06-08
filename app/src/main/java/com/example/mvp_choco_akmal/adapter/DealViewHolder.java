package com.example.mvp_choco_akmal.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mvp_choco_akmal.R;
import com.example.mvp_choco_akmal.entities.DealEntity;

public class DealViewHolder extends RecyclerView.ViewHolder {

    private ImageView dealImage;
    private TextView dealRate;
    private TextView dealTitleShort;
    private TextView dealTitleLong;
    private TextView dealBought;
    private TextView dealPrice;

    public DealViewHolder(@NonNull View itemView){
        super(itemView);
        this.dealImage = itemView.findViewById(R.id.ivDealImage);
        this.dealRate = itemView.findViewById(R.id.tvRate);
        this.dealTitleShort = itemView.findViewById(R.id.tvTitleShort);
        this.dealTitleLong = itemView.findViewById(R.id.tvTitleLong);
        this.dealBought = itemView.findViewById(R.id.tvBought);
        this.dealPrice = itemView.findViewById(R.id.tvPrice);
    }

    public void bind(DealEntity dealEntity){
        dealRate.setText(dealEntity.getDiscount());
        dealTitleShort.setText(dealEntity.getTitleShort());
        dealTitleLong.setText(dealEntity.getTitle());
        dealBought.setText(dealEntity.getBought());
        dealPrice.setText(dealEntity.getPrice());

        Glide.with(itemView)
                .load(dealEntity.getImageUrl())
                .into(dealImage);
    }
}
