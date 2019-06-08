package com.example.mvp_choco_akmal.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DealWrapper {

    @Expose
    @SerializedName("result")
    private List<DealEntity> dealEntityList;

    public List<DealEntity> getDealEntityList(){
        return dealEntityList;
    }
}
