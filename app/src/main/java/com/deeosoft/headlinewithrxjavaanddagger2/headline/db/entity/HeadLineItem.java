package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "HeadLine",
        indices = {@Index(value = {"title", "url", "urlToImage"}, unique = true)}
)
public class HeadLineItem{
    public @PrimaryKey (autoGenerate = true) long id /*= 0*/;

    public String title;
    public String author;
    public String url;
    public String urlToImage;

//    public HeadLineItem(){}
    public HeadLineItem(String title, String author, String url, String urlToImage){
        this.title = title;
        this.author = author;
        this.url = url;
        this.urlToImage = urlToImage;
    }

    /*public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }*/
}
