package com.project.memefeed.ServiceApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
private static Retrofit retrofit = null;
private static String BASE_URL="https://meme-api.com/";
public static MemeApiService getService(){
if(retrofit==null){
    retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
}
return retrofit.create(MemeApiService.class);
}
}
