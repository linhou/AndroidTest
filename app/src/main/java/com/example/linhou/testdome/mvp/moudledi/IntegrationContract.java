package com.example.linhou.testdome.mvp.moudledi;



import com.delta.commonlibs.base.mvp.IModel;
import com.delta.commonlibs.base.mvp.IView;
import com.example.linhou.testdome.mvp.entity.Integration;

import rx.Observable;



public interface IntegrationContract {
    interface Model extends IModel{
        Observable<Integration> getApi(String name);

    }
     interface  View extends IView{
         void showWeb(String s);

    }
}
