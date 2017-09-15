package com.example.linhou.testdome.mvp.moudledi;

import com.delta.commonlibs.utils.RxsRxSchedulers;
import com.example.linhou.testdome.api.ApiService;
import com.example.linhou.testdome.mvp.base.BaseModel;
import com.example.linhou.testdome.mvp.entity.Integration;


import java.util.HashMap;
import java.util.Map;

import rx.Observable;





public class IntegrationModel extends BaseModel<ApiService> implements IntegrationContract.Model {


    public IntegrationModel(ApiService apiService) {
        super(apiService);
    }


    @Override
    public Observable<Integration> getApi(String name) {
        return getService().getIntegration(name).compose(RxsRxSchedulers.<Integration>io_main());
    }
}
