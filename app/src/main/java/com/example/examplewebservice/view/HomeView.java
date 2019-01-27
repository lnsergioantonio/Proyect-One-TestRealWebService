package com.example.examplewebservice.view;

public interface HomeView {
    void logOut();
    void goToLogin();
    void onLoginResult(String message);
    void getUserEmail(String email);
}
