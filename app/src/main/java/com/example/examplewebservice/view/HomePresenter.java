package com.example.examplewebservice.view;

import com.example.examplewebservice.data.preferences.AuthPreferencesImpl;

public class HomePresenter implements HomeContract.Presenter, HomeContract.HomeInteractor.onFinishedListener{

    private HomeView homeView;
    private HomeContract.HomeInteractor homeInteractor;
    private AuthPreferencesImpl preferences;

    public HomePresenter(HomeView homeView, HomeContract.HomeInteractor homeInteractor, AuthPreferencesImpl preferences) {
        this.homeView = homeView;
        this.homeInteractor = homeInteractor;
        this.preferences = preferences;
    }

    @Override
    public void LogOut() {
        homeInteractor.LogOut(this);
    }

    @Override
    public String getEmail() {
        return homeInteractor.getEmail();
    }

    @Override
    public void onFinished(String token) {
        homeView.goToLogin();
    }

    @Override
    public void onFailure(String message) {
        homeView.onLoginResult(message);
    }
}
