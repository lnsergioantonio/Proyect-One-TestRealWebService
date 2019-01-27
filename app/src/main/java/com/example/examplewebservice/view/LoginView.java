package com.example.examplewebservice.view;

public interface LoginView {
    void showProgressDialog();
    void hideProgressDialog();
    void onLoginResult(String message);
    void goToHome();
}
