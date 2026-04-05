package com.project.memefeed.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MemeResponse {
    @SerializedName("count")
    private int count;

    @SerializedName("memes")
    private List<Meme> memes;

    public int getCount() { return count; }
    public List<Meme> getMemes() { return memes; }

    public MemeResponse() {
    }
}
