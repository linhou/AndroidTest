package com.example.linhou.testdome.mvp.moudledi;

import com.delta.commonlibs.utils.GsonTools;
import com.example.linhou.testdome.api.API;
import com.example.linhou.testdome.api.ApiService;
import com.example.linhou.testdome.mvp.entity.Integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Action1;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/9/13.
 */
public class IntegrationPresenterTest {

    @Mock
    IntegrationContract.Model model;
    @Mock
    IntegrationContract.View  view;
    @InjectMocks
    private IntegrationPresenter integrationPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
//       integrationPresenter=  new IntegrationPresenter(model,view);
    }

    @After
    public void tearDown() throws Exception {



    }

    @Test
    public void getApi() throws Exception {
        Integration integration=new Integration();
        integration.setMessage("success");
        integration.setDocumentation_url("www.baidu.com");
        ArrayList<String> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
          list.add("String"+i);
          integration.setList(list);
        }
        when(model.getApi("name")).thenReturn(Observable.just(integration));
        model.getApi("name").subscribe(new Action1<Integration>() {
            @Override
            public void call(Integration checkStock) {
                assertEquals(checkStock.getMessage(),"success");
                assertEquals(checkStock.getDocumentation_url(),"www.baidu.com");
                assertThat(checkStock.getList().size(),is(10));
            }
        });



    }

    @Test
    public void getApi2() throws Exception {
        String json="{ \"message\": \"Not Found\",\"documentation_url\": \"https://developer.github.com/v3\"}";
        MockWebServer mockWebServer = new MockWebServer();
//        .throttleBody(10,1,TimeUnit.SECONDS)
//        mockWebServer.enqueue(new MockResponse().setResponseCode(404).setBody(json));
        mockWebServer.enqueue(new MockResponse().setResponseCode(200).setBody(json));
        mockWebServer.start();
        HttpUrl baseUrl = mockWebServer.url("");
        Retrofit retrofitmock = new Retrofit.Builder()
                .baseUrl(baseUrl.toString())
                .addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        ApiService iServer = retrofitmock.create(ApiService.class);
        Observable<Integration> observable=iServer.getIntegration("");
        observable.subscribe(new Action1<Integration>() {
            @Override
            public void call(Integration integration) {
                System.out.println(integration.getMessage());
                assertEquals(integration.getMessage(), "Not Found");
                assertEquals(integration.getDocumentation_url(), "https://developer.github.com/v3");
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                System.out.println(throwable.toString());
            }
        });

    }

    @Test
    public void isSuccess() throws Exception {
        Integration integration=new Integration();
        integration.setMessage("Not Found");
        assertEquals(true,  integrationPresenter.isSuccess(integration));//见gralde文件配置
        Integration integration1=new Integration();
        integration1.setMessage("success");
        assertEquals(false,  integrationPresenter.isSuccess(integration1));
        Integration integration2=new Integration();
        integration2.setMessage("");
        assertEquals(true,  integrationPresenter.isSuccess(integration2));
    }
    @Test
    public void isSuccess2() throws Exception {
        Integration integration=new Integration();
        integration.setMessage("Not Found");
        assertEquals(true,  integrationPresenter.isSuccess2(integration));//见gralde文件配置
        Integration integration1=new Integration();
        integration1.setMessage("success");
        assertEquals(false,  integrationPresenter.isSuccess2(integration1));
    }



}