package com.example.examplewebservice.data.preferences;

import android.content.Context;

public interface AuthPreferences {
    //AuthPreferencesImpl getSharedPreference(Context context, String prefFileName);
    void setCurrentEmail(String email);
    void setCurrentToken(String token);
    String getCurrentEmail();
    String getCurrentToken();
}
