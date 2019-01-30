package com.example.examplewebservice.view.login;

import com.example.examplewebservice.data.DataManager;
import com.example.examplewebservice.view.base.SessionContract;

public class LoginPresenter implements SessionContract.PresenterLogin, SessionContract.UserInteractor.onFinishedListener {

    private LoginView loginView;
    private DataManager dataManager;

    public LoginPresenter(LoginView loginView, DataManager dataManager) {
        this.dataManager=dataManager;
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        loginView.showProgressDialog();
        dataManager.login(email,password,this);
    }

    @Override
    public void onFinished(String token) {
        dataManager.setCurrentToken(token);
        loginView.hideProgressDialog();
        loginView.goToHome();
    }

    @Override
    public void onFailure(String message) {
        loginView.hideProgressDialog();
        loginView.onLoginResult(message);
    }
}

