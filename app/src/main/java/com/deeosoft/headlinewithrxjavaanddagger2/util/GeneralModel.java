package com.deeosoft.headlinewithrxjavaanddagger2.util;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GeneralModel<T> {
    @SerializedName("status")
    String status;
    @SerializedName("totalResults")
    int totalResults;
    @SerializedName("articles")
    public T article;
}
