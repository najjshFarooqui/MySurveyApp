package com.example.administrator.retroitfetchdata.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class AuthPreference {

    private static final String DB_NAME = "auth_preference";
    //TODO: Add preference for all user attributes

    public static void setDeviceToken(Context context, String deviceToken) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("deviceToken", deviceToken);
        editor.apply();
    }

    public static String getDeviceToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("deviceToken", null);
    }

    public static void setUserLoggedIn(Context context, boolean flag) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("userLogin", flag);
        editor.apply();
    }

    public static boolean isUserLoggedIn(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DB_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("userLogin", false);
    }
}
