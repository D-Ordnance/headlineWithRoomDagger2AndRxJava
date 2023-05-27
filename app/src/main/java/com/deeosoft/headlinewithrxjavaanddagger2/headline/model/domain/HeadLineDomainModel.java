package com.deeosoft.headlinewithrxjavaanddagger2.headline.model.domain;

import com.google.gson.annotations.SerializedName;

public class HeadLineDomainModel {
    public String author;
    public String title;
    public String url;
    public String imageSrc;

    public HeadLineDomainModel(String author, String title, String url, String imageSrc){
        this.author = author;
        this.title = title;
        this.url = url;
        this.imageSrc = imageSrc;
    }
}
