package com.example.examplewebservice.view;

public interface HomeContract {
    interface Presenter{
        void LogOut();
        String getEmail();
    }
    interface HomeInteractor{
        interface onFinishedListener{
            void onFinished(String token);
            void onFailure(String message);
        }
        void LogOut(onFinishedListener finishedListener);
        String getEmail();
    }
}
