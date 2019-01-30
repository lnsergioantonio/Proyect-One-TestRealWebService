package com.example.examplewebservice.view.login;

public interface LoginView {
    void showProgressDialog();
    void hideProgressDialog();
    void onLoginResult(String message);
    void goToHome();
}
