package com.example.movicelselfcare;

import android.content.Context;
import android.content.SharedPreferences;

public class CustomSharedPreferences {
    public static final String APP_PREFERENCES = "SelfCareApp";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public CustomSharedPreferences(Context context) {
        // TODO Auto-generated constructor stub
        prefs = getMyPreferences(context);
        editor = prefs.edit();
    }

    private static SharedPreferences getMyPreferences(Context context) {
        return context.getSharedPreferences(APP_PREFERENCES,
                Context.MODE_PRIVATE);
    }

    public void clearAllSharedPreferences() {
        editor.clear();
        editor.commit();
    }

    public boolean isGuestLogin() {
        return prefs.getBoolean("guestLogin", false);
    }

    public void setGuestLogin(boolean userId) {
        editor.putBoolean("guestLogin", userId).commit();
    }

    public String getLanguage() {
        return prefs.getString("language", "en");
    }

    public void setLanguage(String userId) {
        editor.putString("language", userId).commit();
    }

}
