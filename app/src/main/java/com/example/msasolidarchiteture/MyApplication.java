package com.example.msasolidarchiteture;

import android.app.Application;

import com.example.msasolidarchiteture.di.DaggerRetroComponent;
import com.example.msasolidarchiteture.di.RetroComponent;
import com.example.msasolidarchiteture.di.RetroModule;

public class MyApplication extends Application {

    private RetroComponent retroComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        retroComponent = DaggerRetroComponent.builder()
                .retroModule(new RetroModule())
                .build();
    }
    public RetroComponent getRetroComponent(){
        return retroComponent;
    }
}
