package com.example.examplewebservice.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class AuthPreferencesImpl implements AuthPreferences {

    private static final String LOGTAG="AuthPreferencesImpl";

    private static final String PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL";
    private static final String PREF_KEY_ACCESS_TOKEN = "PREF_KEY_ACCESS_TOKEN";

    private final SharedPreferences preferences;

    private static AuthPreferencesImpl authPreferences;

    private AuthPreferencesImpl(Context context, String prefFileName){
        this.preferences = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE);
    }

    public static AuthPreferencesImpl getSharedPreference(Context context, String prefFileName) {
        if(authPreferences==null){
            authPreferences = new AuthPreferencesImpl(context,prefFileName);
        }else{
            Log.e(LOGTAG,"No se puede crear otro objeto SharedPreferences por que ya existe uno");
        }
        return authPreferences;
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
