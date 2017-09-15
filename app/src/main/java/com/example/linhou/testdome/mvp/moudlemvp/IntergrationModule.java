package com.example.linhou.testdome.mvp.moudlemvp;


import com.delta.commonlibs.di.scope.ActivityScope;
import com.example.linhou.testdome.api.ApiService;
import com.example.linhou.testdome.mvp.moudledi.IntegrationContract;
import com.example.linhou.testdome.mvp.moudledi.IntegrationModel;


import dagger.Module;
import dagger.Provides;



@Module
public class IntergrationModule {
    IntegrationContract.View view;
    public IntergrationModule(IntegrationContract.View view) {
        this.view = view;
    }
    @ActivityScope
    @Provides
    public IntegrationContract.View providerView() {
        return view;
    }
    @ActivityScope
    @Provides
    public IntegrationContract.Model providerModel(ApiService service) {
        return new IntegrationModel(service);
    }
}
