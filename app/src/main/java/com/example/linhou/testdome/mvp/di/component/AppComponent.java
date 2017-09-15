package com.example.linhou.testdome.mvp.di.component;

import android.app.Application;

import com.delta.commonlibs.di.module.AppModule;
import com.delta.commonlibs.di.module.ClientModule;

import com.example.linhou.testdome.api.ApiService;
import com.example.linhou.testdome.di.module.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by V.Wenju.Tian on 2016/11/22.
 */
@Singleton
@Component(modules = {AppModule.class, ClientModule.class, ServiceModule.class})
public interface AppComponent {

    Application Application();

    ApiService apiService();

}
