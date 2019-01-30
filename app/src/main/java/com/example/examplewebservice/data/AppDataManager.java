package com.example.examplewebservice.data;
import com.example.examplewebservice.data.preferences.AuthPreferences;
import com.example.examplewebservice.view.base.SessionContract;

public class AppDataManager implements DataManager {
    public static final String LOGTAG = "DataManager";
    private SessionContract.UserInteractor userInteractor;
    private AuthPreferences authPreferences;

    public AppDataManager(SessionContract.UserInteractor userInteractor, AuthPreferences authPreferences) {
        this.userInteractor = userInteractor;
        this.authPreferences = authPreferences;
    }

    @Override
    public void updateUserInfo(String email, String token) {
        authPreferences.setCurrentEmail(email);
        authPreferences.setCurrentToken(token);
    }

    @Override
    public void setCurrentEmail(String email) {
        authPreferences.setCurrentEmail(email);
    }

    @Override
    public void setCurrentToken(String token) {
        authPreferences.setCurrentToken(token);
    }

    @Override
    public String getCurrentEmail() {
        return authPreferences.getCurrentEmail();
    }

    @Override
    public String getCurrentToken() {
        return authPreferences.getCurrentToken();
    }

    @Override
    public void login(String email, String password, onFinishedListener onFinishedListener) {
        userInteractor.login(email,password,onFinishedListener);
    }

    @Override
    public void logout(onFinishedListenerLogout onFinishedListenerLogout) {
        userInteractor.logout(onFinishedListenerLogout);
    }
}
