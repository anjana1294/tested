package com.example.admin.demoretrofit;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesManager {
    private static final String MyPREFERENCES = "demoretrofit";

    private SharedPreferences sharedPreferences;
    private final static SharedPreferencesManager sharedPreferencesManager = null;

    public static SharedPreferencesManager getInstance() {
        if (sharedPreferencesManager == null) {
            return new SharedPreferencesManager();
        }
        return sharedPreferencesManager;
    }

    public void initSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
    }


    public void putStringValue(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void putIntValue(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public void putBooleanValue(String key, boolean value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public void putFloatValue(String key, float value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

    public void clearSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }


    public String getUsername() {
        return sharedPreferences.getString("username", "");
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }


    public boolean isRemembreMe() {
        return sharedPreferences.getBoolean("isRememberMe", false);
    }

    public String getUserID() {
        return sharedPreferences.getString("userID", "");
    }

    public String getProfileImage() {
        return sharedPreferences.getString("profileImage", "");
    }

    public String getEventName() {
        return sharedPreferences.getString("eventName", "");
    }

    public String getUserEmail() {
        return sharedPreferences.getString("email", "");
    }

    public String getUserPhone() {
        return sharedPreferences.getString("phone", "");
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean("isLoggedIn", false);
    }

    public boolean isTimerStarted() {
        return sharedPreferences.getBoolean("isTimerStarted", false);
    }

    public String getToken(){
        return sharedPreferences.getString("token","");
    }

}
