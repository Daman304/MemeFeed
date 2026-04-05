package com.project.memefeed.ServiceApi;

import com.project.memefeed.models.MemeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MemeApiService {
    @GET("gimme/{count}")
    Call<MemeResponse> getMemes(@Path("count") int count);
}
