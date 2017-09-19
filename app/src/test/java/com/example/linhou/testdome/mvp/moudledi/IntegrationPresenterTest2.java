package com.example.linhou.testdome.mvp.moudledi;

import com.example.linhou.testdome.api.ApiService;
import com.example.linhou.testdome.mvp.entity.Integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/9/13.
 */
public class IntegrationPresenterTest2 {

    @Mock
    IntegrationContract.Model model;
    @Mock
    IntegrationContract.View  view;

    @InjectMocks
    private IntegrationPresenter integrationPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        //integrationPresenter=new IntegrationPresenter(model,view);
    }

    @After
    public void tearDown() throws Exception {



    }

    @Test
    public void getApi() throws Exception {
        //使用mock数据，验证网络强求是否符合自己设想
        Integration integration=new Integration();
        integration.setMessage("success");
        integration.setDocumentation_url("www.baidu.com");
        when(model.getApi("name")).thenReturn(Observable.just(integration));
        model.getApi("name").subscribe(new Action1<Integration>() {
            @Override
            public void call(Integration checkStock) {
                assertEquals(checkStock.getMessage(),"success");
                assertEquals(checkStock.getDocumentation_url(),"www.baidu.com");
            }
        });



    }

    @Test
    public void getPersenter() throws  Exception{
        integrationPresenter.getPersenter(true);
        assertEquals("m",integrationPresenter.getPersenter(true));
    }




}