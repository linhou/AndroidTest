package com.example.linhou.testdome.robolectric;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.linhou.testdome.SharedPreferencesUtils;

/**
 * Created by Lin.Hou on 2017/9/26.
 */

public class ServiceUnit extends IntentService {

    public ServiceUnit() {
        super("");
        Log.d("info", "ServiceUnit() called");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        SharedPreferences.Editor editor = getSharedPreferences("example", Context.MODE_PRIVATE).edit();
        editor.putString("id", "王五");
        editor.commit();
        Log.d("info", "onCreate() called"+getSharedPreferences("example", Context.MODE_PRIVATE).getString("id",null));
    }
}
