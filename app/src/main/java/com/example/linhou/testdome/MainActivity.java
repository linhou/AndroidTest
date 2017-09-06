package com.example.linhou.testdome;

import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.linhou.testdome.retrofit.IRetrofit;
import com.example.linhou.testdome.retrofit.RetrofitBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.22.40.109/").addConverterFactory(GsonConverterFactory.create())
                .build();
        IRetrofit service = retrofit.create(IRetrofit.class);
        Call<RetrofitBean> call = service.listRepos();



    }
}
