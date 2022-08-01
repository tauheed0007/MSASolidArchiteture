package com.example.msasolidarchiteture.di;


import com.example.msasolidarchiteture.viewmodel.MovieListViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {
    public void inject (MovieListViewModel movieListViewModel);
}
