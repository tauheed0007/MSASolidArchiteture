package com.example.msasolidarchiteture.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.msasolidarchiteture.MyApplication;
import com.example.msasolidarchiteture.di.RetroServiceInterface;
import com.example.msasolidarchiteture.model.RecyclerList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends AndroidViewModel {

    @Inject
    RetroServiceInterface mService;

     MutableLiveData<RecyclerList> liveDataList;

    public MovieListViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication)application).getRetroComponent().inject(MovieListViewModel.this);
        liveDataList = new MutableLiveData<>();
    }

    public MutableLiveData<RecyclerList> getRecyclerListObserver() {
        return liveDataList;
    }

    public void makeApiCall() {
        Call<RecyclerList> call = mService.getDataFromAPI("newyork");
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                if(response.isSuccessful()) {
                    liveDataList.postValue(response.body());
                } else {
                    liveDataList.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveDataList.postValue(null);
            }
        });
    }
}
