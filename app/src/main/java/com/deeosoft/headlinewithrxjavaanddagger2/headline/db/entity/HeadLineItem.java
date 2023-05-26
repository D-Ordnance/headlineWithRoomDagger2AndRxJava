package com.deeosoft.headlinewithrxjavaanddagger2.headline.db.entity;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "HeadLine",
        indices = {@Index(value = {"title", "url", "urlToImage"}, unique = true)}
)
public class HeadLineItem implements Serializable {
    public @PrimaryKey(autoGenerate = true) long id;
    public String title;
    public String author;
    public String url;
    public String urlToImage;

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
