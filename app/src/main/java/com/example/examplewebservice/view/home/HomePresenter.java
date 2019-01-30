package com.example.examplewebservice.view.home;

import com.example.examplewebservice.data.DataManager;
import com.example.examplewebservice.view.base.SessionContract;

public class HomePresenter implements SessionContract.PresenterLogout, SessionContract.UserInteractor.onFinishedListenerLogout {

    private HomeView homeView;
    private DataManager dataManager;

    public HomePresenter(HomeView homeView, DataManager dataManager) {
        this.homeView = homeView;
        this.dataManager= dataManager;
    }

    @Override
    public void LogOut() {
        homeView.showProgressDialog();
        dataManager.logout(this);
    }

    @Override
    public void onFinished() {
        homeView.hideProgressDialog();
        homeView.goToLogin();
    }

    @Override
    public void onFailure(String message) {
        homeView.hideProgressDialog();
        homeView.onResponse(message);
    }
}
