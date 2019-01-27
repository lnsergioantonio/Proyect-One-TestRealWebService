package com.example.examplewebservice.presenter;

public interface LoginContract {

    interface Presenter{
        void onLogin(String email, String password);
        //void requestDataFromServer();
    }
    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface UserInteractor{
        interface onFinishedListener{
            void onFinished(String token);
            void onFailure(String message);
        }
        void login(String email, String password, onFinishedListener onFinishedListener);
    }
}
