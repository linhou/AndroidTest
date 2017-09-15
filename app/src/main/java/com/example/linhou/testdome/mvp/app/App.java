package com.example.linhou.testdome.mvp.app;



import com.example.linhou.testdome.api.API;
import com.example.linhou.testdome.mvp.base.BaseApplication;
import com.example.linhou.testdome.mvp.di.component.AppComponent;
import com.example.linhou.testdome.mvp.di.component.DaggerAppComponent;


/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */

public class App extends BaseApplication {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().clientModule(getClientModule()).appModule(getAppModule()).serviceModule(getServiceModule()).build();
    }

    @Override
    protected String getBaseUrl() {
        return API.BASE_URL;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
