package com.example.examplewebservice.data;

import com.example.examplewebservice.data.preferences.AuthPreferences;
import com.example.examplewebservice.view.base.SessionContract;

public interface DataManager extends AuthPreferences, SessionContract.UserInteractor{
    void updateUserInfo(String email, String token);
}
