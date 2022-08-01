package com.example.msasolidarchiteture.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class RetroModule {
    private String baseURL = "https://api.yelp.com/v3/businesses/";

    @Singleton
    @Provides
    public RetroServiceInterface getRetroServiceInterface(Retrofit retrofit) {

        return retrofit.create(RetroServiceInterface.class);
    }
    @Singleton
    @Provides
    public Retrofit getRetrofitInstance () {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
