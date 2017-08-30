package com.example.linhou.testdome;

import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.linhou.testdome.retrofit.IRetrofit;
import com.example.linhou.testdome.retrofit.RetrofitBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.22.40.109/")
                .build();
        IRetrofit service = retrofit.create(IRetrofit.class);
        Call<RetrofitBean> call = service.listRepos();


    }
}
