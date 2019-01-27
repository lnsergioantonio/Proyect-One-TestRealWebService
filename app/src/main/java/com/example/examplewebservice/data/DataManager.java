package com.example.examplewebservice.data;

import com.example.examplewebservice.data.api.UserService;
import com.example.examplewebservice.data.preferences.AuthPreferences;

public interface DataManager extends UserService, AuthPreferences {
    void LogOut();
}
