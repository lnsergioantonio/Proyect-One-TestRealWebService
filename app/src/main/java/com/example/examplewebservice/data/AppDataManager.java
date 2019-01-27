package com.example.examplewebservice.data;

import com.example.examplewebservice.data.api.UserServiceImpl;
import com.example.examplewebservice.data.api.model.LoginBody;
import com.example.examplewebservice.data.database.model.User;

import retrofit2.Call;

public class AppDataManager implements DataManager {

    public static final String LOGTAG="DataManager";

    @Override
    public void LogOut() {

    }

    @Override
    public Call<User> loginWithEmail(LoginBody loginBody) {
        return null;
    }

    @Override
    public void setCurrentEmail(String email) {

    }

    @Override
    public void setCurrentToken(String token) {

    }

    @Override
    public String getCurrentEmail() {
        return null;
    }

    @Override
    public String getCurrentToken() {
        return null;
    }
}
