package com.example.examplewebservice.Presenter;

import com.example.examplewebservice.Services.UserService;
import com.example.examplewebservice.View.ILoginView;

public class LoginPresenter implements MainContract.Presenter, MainContract.UserInteractor.onFinishedListener {

    private ILoginView loginView;
    private MainContract.UserInteractor userInteractor;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
        this.userInteractor = new UserService();
    }

    @Override
    public void onLogin(String email, String password) {
        loginView.showProgressDialog();
        userInteractor.login(email,password,this);
    }

    @Override
    public void onFinished() {
        loginView.hideProgressDialog();
        loginView.goToHome();
    }

    @Override
    public void onFailure(String message) {
        loginView.hideProgressDialog();
        loginView.onLoginResult(message);
    }
}
