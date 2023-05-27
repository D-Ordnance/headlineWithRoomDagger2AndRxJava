package com.deeosoft.headlinewithrxjavaanddagger2.headline.network;

import com.google.gson.annotations.SerializedName;

public class HeadLineNetworkModel {
    @SerializedName("author")
    public String author;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String url;
    @SerializedName("urlToImage")
    public String imageSrc;
}
