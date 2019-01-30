package com.example.examplewebservice.view.base;

public interface SessionContract {
    interface PresenterLogin{
        void onLogin(String email, String password);
    }
    interface PresenterLogout{
        void LogOut();
    }
    interface UserInteractor{
        interface onFinishedListener{
            void onFinished(String token);
            void onFailure(String message);
        }

        void login(String email, String password, onFinishedListener onFinishedListener);

        interface onFinishedListenerLogout{
            void onFinished();
            void onFailure(String message);
        }
        void logout(onFinishedListenerLogout onFinishedListenerLogout);
    }

}
