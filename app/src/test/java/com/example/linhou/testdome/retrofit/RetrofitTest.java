package com.example.linhou.testdome.retrofit;


import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/8/28.
 */
public class RetrofitTest {


    private IRetrofit service;
    private IRetrofit service1;
//    @Mock
//    private IRetrofit service1;

    @Before
    public void setUp() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.22.40.109/").addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(IRetrofit.class);
        service1 = new Retrofit.Builder().baseUrl("http://172.22.40.109/").build().create(IRetrofit.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    //@Ignore//测试jacoco的命令时专门注释的
    @Test
    public void testRetrofit() throws Exception {
        Call<RetrofitBean> calls = service.listRepos();
        System.out.println(calls.execute().code());
        assertEquals(200, calls.execute().code());

    }

    @Test
    public void mockRetrofitSuccess() throws Exception {
        String json = "{\"code\":0,\"message\":\"success\",\"rows\":{\"id\":6,\"startTime\":\"Aug 29, 2017 10:38:41 AM\",\"status\":\"盘点中\",\"userName\":\"admin\",\"completedSubShelf\":[{\"lightid\":1,\"labelCode\":\"T-000001\",\"labelSerial\":\"879906000000000001\",\"status\":0},{\"lightid\":3,\"labelCode\":\"T-000002\",\"labelSerial\":\"879906000000000002\",\"status\":0},{\"lightid\":5,\"labelCode\":\"T-000004\",\"labelSerial\":\"879906000000000008\",\"status\":0},{\"lightid\":6,\"labelCode\":\"T-000005\",\"labelSerial\":\"879906000000000010\",\"status\":0},{\"lightid\":7,\"labelCode\":\"T-000006\",\"labelSerial\":\"879906000000000020\",\"status\":0},{\"lightid\":8,\"labelCode\":\"T-000007\",\"labelSerial\":\"879906000000000040\",\"status\":0}]}}";
        MockWebServer mockWebServer = new MockWebServer();
        //創建mockWebServer的數據，其中包括200等信息
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(json));
       // mockWebServer.enqueue(new MockResponse().setBody(json));
        //啓動mockWebServer
        mockWebServer.start();
        //獲取URL地址
        HttpUrl baseUrl = mockWebServer.url("");
        Retrofit retrofitmock = new Retrofit.Builder()
                .baseUrl(baseUrl.toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IRetrofit iServer = retrofitmock.create(IRetrofit.class);
        long time = System.currentTimeMillis();
        Call<RetrofitBean> servercall = iServer.listRepos();
        //System.out.println(servercall.execute().code());
//        assertEquals(200, servercall.execute().code());
        assertEquals(0,servercall.execute().body().getCode());
        System.out.println((System.currentTimeMillis())-time);
        //關閉server
        mockWebServer.shutdown();
    }

    @Test
    public void mockwebServer() throws Exception{
        String json = "{\"code\":0,\"message\":\"success\",\"rows\":{\"id\":6,\"startTime\":\"Aug 29, 2017 10:38:41 AM\",\"status\":\"盘点中\",\"userName\":\"admin\",\"completedSubShelf\":[{\"lightid\":1,\"labelCode\":\"T-000001\",\"labelSerial\":\"879906000000000001\",\"status\":0},{\"lightid\":3,\"labelCode\":\"T-000002\",\"labelSerial\":\"879906000000000002\",\"status\":0},{\"lightid\":5,\"labelCode\":\"T-000004\",\"labelSerial\":\"879906000000000008\",\"status\":0},{\"lightid\":6,\"labelCode\":\"T-000005\",\"labelSerial\":\"879906000000000010\",\"status\":0},{\"lightid\":7,\"labelCode\":\"T-000006\",\"labelSerial\":\"879906000000000020\",\"status\":0},{\"lightid\":8,\"labelCode\":\"T-000007\",\"labelSerial\":\"879906000000000040\",\"status\":0}]}}";
        MockWebServer mockWebServer = new MockWebServer();
        //創建mockWebServer的數據，其中包括200等信息
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(json).throttleBody(10,1, TimeUnit.SECONDS));
        // mockWebServer.enqueue(new MockResponse().setBody(json));
        //啓動mockWebServer
        mockWebServer.start();
        //獲取URL地址
        HttpUrl baseUrl = mockWebServer.url("");
        Retrofit retrofitmock = new Retrofit.Builder()
                .baseUrl(baseUrl.toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IRetrofit iServer = retrofitmock.create(IRetrofit.class);
        long time = System.currentTimeMillis();
        Call<RetrofitBean> servercall = iServer.listRepos();
        //System.out.println(servercall.execute().code());
//        assertEquals(200, servercall.execute().code());
        assertEquals(0,servercall.execute().body().getCode());
        System.out.println((System.currentTimeMillis())-time);
        //關閉server
        mockWebServer.shutdown();
    }


    @Test
    public void testmockwebServer() throws Exception{
        final String json1="{\"code\":0,\"message\":\"success\",\"rows\":{\"id\":6,\"startTime\":\"Aug 29, 2017 10:38:41 AM\",\"status\":\"盘点中\",\"userName\":\"admin\",\"completedSubShelf\":[{\"lightid\":1,\"labelCode\":\"T-000001\",\"labelSerial\":\"879906000000000001\",\"status\":0},{\"lightid\":3,\"labelCode\":\"T-000002\",\"labelSerial\":\"879906000000000002\",\"status\":0},{\"lightid\":5,\"labelCode\":\"T-000004\",\"labelSerial\":\"879906000000000008\",\"status\":0},{\"lightid\":6,\"labelCode\":\"T-000005\",\"labelSerial\":\"879906000000000010\",\"status\":0},{\"lightid\":7,\"labelCode\":\"T-000006\",\"labelSerial\":\"879906000000000020\",\"status\":0},{\"lightid\":8,\"labelCode\":\"T-000007\",\"labelSerial\":\"879906000000000040\",\"status\":0}]}}";
        MockWebServer testServer = new MockWebServer();
        Dispatcher dispatcher=new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
                if(request.getPath().equals("/ams/pcb/inventory/ongoing")) {
                    return new MockResponse().setResponseCode(200);
                } else if(request.getPath().equals("/ams/pcb/inventory/ongoing1")) {
                    return new MockResponse().setResponseCode(500);
                } else if(request.getPath().equals("/ams/pcb/inventory/ongoing2")) {
                    return new MockResponse().setBody(json1);
                }
                return new MockResponse().setResponseCode(404);
            }
        };
        testServer.setDispatcher(dispatcher);
        RecordedRequest request = testServer.takeRequest();
        assertEquals("GET /ams/pcb/inventory/ongoing HTTP/1.1", request.getRequestLine());
        HttpUrl baseUrl = testServer.url("");
        Retrofit retrofitmock = new Retrofit.Builder()
                .baseUrl(baseUrl.toString())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IRetrofit iServer = retrofitmock.create(IRetrofit.class);
        System.out.println(iServer.listRepos().execute().code());
    }




}