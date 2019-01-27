package com.example.examplewebservice.presenter;

import com.example.examplewebservice.data.preferences.AuthPreferencesImpl;
import com.example.examplewebservice.view.LoginView;

public class LoginPresenter implements LoginContract.Presenter, LoginContract.UserInteractor.onFinishedListener {

    private LoginView loginView;
    private LoginContract.UserInteractor userInteractor;
    private AuthPreferencesImpl preferences;

    public LoginPresenter(LoginView loginView, LoginContract.UserInteractor userInteractor, AuthPreferencesImpl preferences) {
        this.preferences= preferences;
        this.loginView = loginView;
        this.userInteractor = userInteractor;
    }

    @Override
    public void onLogin(String email, String password) {
        loginView.showProgressDialog();
        preferences.setCurrentEmail(email);
        userInteractor.login(email,password,this);
    }

    @Override
    public void onFinished(String token) {
        preferences.setCurrentToken(token);
        loginView.hideProgressDialog();
        loginView.goToHome();
    }

    @Override
    public void onFailure(String message) {
        loginView.hideProgressDialog();
        loginView.onLoginResult(message);
    }
}

