package com.example.linhou.testdome.retrofit;


import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/8/28.
 */
public class RetrofitTest {


    private IRetrofit service;
//    @Mock
//    private IRetrofit service1;

    @Before
    public void setUp() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.22.40.109/").addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(IRetrofit.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    //@Ignore//测试jacoco的命令时专门注释的
    @Test
    public void testRetrofit() throws Exception {
        Call<RetrofitBean> calls = service.listRepos();
        assertEquals(200,calls.execute().code());
//       System.out.println(calls.execute().toString());
//        System.out.println(calls.execute().code());
//        Response<RetrofitBean> execute = calls.execute();
//        Log.i("info", "testRetrofit: " + execute.body().getCode());


    }


}