package com.example.msasolidarchiteture.di;
import com.example.msasolidarchiteture.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {

    double Latitude = 37.724285422046194;
    double Longitude = -122.43116553554718;

    @GET("search")
    Call<RecyclerList> getDataFromAPI(@Query("term=pizza&"+Latitude+"&"+Longitude)String query);
}
