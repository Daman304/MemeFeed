package com.project.memefeed.models;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meme extends BaseObservable {
@SerializedName("postLink")
@Expose
private String postLink;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("author")
    @Expose
    private String author;
    @BindingAdapter("imageUrl")
public static void loadImage(ImageView imageView,String url){
    Glide.with(imageView.getContext()).load(url).into(imageView);
}
    public String getPostLink() {
        return postLink;
    }

    public void setPostLink(String postLink) {
        this.postLink = postLink;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
