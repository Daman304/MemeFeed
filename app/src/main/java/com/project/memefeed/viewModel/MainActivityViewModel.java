package com.project.memefeed.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.project.memefeed.models.Meme;
import com.project.memefeed.models.MemeRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private MemeRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository=new MemeRepository(application);
    }
public LiveData<List<Meme>> getAllMemes(){return repository.getMutableLiveData();}
}
