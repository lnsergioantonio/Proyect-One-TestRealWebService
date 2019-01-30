package com.example.examplewebservice.view.home;

public interface HomeView {
    void logOut();
    void goToLogin();
    void onResponse(String message);
    void showProgressDialog();
    void hideProgressDialog();

    //void getUserEmail(String email);
}
