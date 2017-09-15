package com.example.linhou.testdome.di.module;


import com.example.linhou.testdome.api.ApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;


@Module
public class ServiceModule {

    @Singleton
    @Provides
    ApiService provideCommonService(Retrofit retrofit) {

        return retrofit.create(ApiService.class);
    }

}
