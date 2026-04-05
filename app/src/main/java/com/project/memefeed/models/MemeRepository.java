package com.project.memefeed.models;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.project.memefeed.ServiceApi.MemeApiService;
import com.project.memefeed.ServiceApi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MemeRepository {
    private ArrayList<Meme> memes=new ArrayList<>();
    private MutableLiveData<List<Meme>> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public MemeRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Meme>> getMutableLiveData() {
        MemeApiService memeApiService= RetrofitInstance.getService();
        Call<MemeResponse> call = memeApiService.getMemes(15);
        call.enqueue(new Callback<MemeResponse>() {
            @Override
            public void onResponse(Call<MemeResponse> call, Response<MemeResponse> response) {
                MemeResponse memeResponse=response.body();
                if(memeResponse!=null&&memeResponse.getMemes()!=null){
                    memes=(ArrayList<Meme>) memeResponse.getMemes();
                    mutableLiveData.setValue(memes);
                }
            }

            @Override
            public void onFailure(Call<MemeResponse> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }
}
