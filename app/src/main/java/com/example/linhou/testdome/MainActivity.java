package com.example.linhou.testdome;

import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.linhou.testdome.retrofit.IRetrofit;
import com.example.linhou.testdome.retrofit.RetrofitBean;
import com.example.linhou.testdome.unitcase.Calculator;
import com.example.linhou.testdome.unitcase.SpyUnit;
import com.example.linhou.testdome.unitcase.SpyUnit2;
import com.example.linhou.testdome.unitcase.SpyUnit4;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =" MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpyUnit4 spyUnit4=new SpyUnit4();
        SpyUnit2 spyUnit2=new SpyUnit2();
        spyUnit4.setSpyA(1);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + spyUnit2.getSpyA() + "]");
        Calculator calculator1=Calculator.getInstance();
        Calculator calculator2=Calculator.getInstance();
        calculator1.setA(1);
        Log.d(TAG, "onCreate() called with: calculator2 = [" + calculator2.getA() + "]");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
