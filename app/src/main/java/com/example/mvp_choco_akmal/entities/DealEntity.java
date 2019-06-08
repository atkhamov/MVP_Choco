package com.example.mvp_choco_akmal.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealEntity {

    @Expose
    @SerializedName("discount")
    private int discount;

    @Expose
    @SerializedName("image_kind")
    private String imageKind;

    @Expose
    @SerializedName("image_url")
    private String imageUrl;

    @Expose
    @SerializedName("image_url_wide")
    private String imageUrlWide;

    @Expose
    @SerializedName("price")
    private int price;

    @Expose
    @SerializedName("title_short")
    private String titleShort;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("reviews_rate")
    private double reviewsRate;

    @Expose
    @SerializedName("bought")
    private int bought;

    public int getDiscount() {
        return discount;
    }

    public String getImageKind() {
        return imageKind;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImageUrlWide() {
        return imageUrlWide;
    }

    public int getPrice() {
        return price;
    }

    public String getTitleShort() {
        return titleShort;
    }

    public String getTitle() {
        return title;
    }

    public double getReviewsRate() {
        return reviewsRate;
    }

    public int getBought() {
        return bought;
    }
}
