package com.example.linhou.testdome;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lin.Hou on 2017/8/23.
 */

public class SharedPreferencesUtils {

    private static SharedPreferencesUtils instance;
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public SharedPreferencesUtils(Context context) {
        sharedPreferences = context.getSharedPreferences("test", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }




    public static SharedPreferencesUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (SharedPreferencesUtils.class) {
                if (instance == null) {
                    instance = new SharedPreferencesUtils(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    public static void setUserId(String userId) {
        editor.putString("userId", userId);
        editor.commit();
    }

    public static String getUserId() {
        return sharedPreferences.getString("userId", "");
    }


}
