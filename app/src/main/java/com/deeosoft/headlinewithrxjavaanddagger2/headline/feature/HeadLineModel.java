package com.deeosoft.headlinewithrxjavaanddagger2.headline.feature;

import com.google.gson.annotations.SerializedName;

public class HeadLineModel {
    @SerializedName("author")
    public String author;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("urlToImage")
    public String imageSrc;
}
