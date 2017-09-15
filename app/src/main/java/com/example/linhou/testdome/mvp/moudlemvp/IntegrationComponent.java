package com.example.linhou.testdome.mvp.moudlemvp;


import com.delta.commonlibs.di.scope.ActivityScope;
import com.example.linhou.testdome.mvp.IntegrationTestActivity;
import com.example.linhou.testdome.mvp.di.component.AppComponent;


import dagger.Component;


@ActivityScope
@Component(modules = IntergrationModule.class, dependencies = AppComponent.class)
public interface IntegrationComponent {
    void inject(IntegrationTestActivity activity);
}
