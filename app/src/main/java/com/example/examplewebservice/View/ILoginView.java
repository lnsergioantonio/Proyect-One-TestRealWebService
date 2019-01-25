package com.example.examplewebservice.View;

public interface ILoginView {
    void showProgressDialog();
    void hideProgressDialog();
    void onLoginResult(String message);
    void goToHome();
}
