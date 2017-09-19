package com.example.linhou.testdome.mvp.moudledi;

import android.text.TextUtils;
import android.util.Log;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.delta.commonlibs.di.scope.ActivityScope;
import com.example.linhou.testdome.mvp.entity.Integration;

import javax.inject.Inject;

import rx.functions.Action1;



@ActivityScope
public class IntegrationPresenter extends BasePresenter<IntegrationContract.Model, IntegrationContract.View> {
    @Inject
    public IntegrationPresenter(IntegrationContract.Model model, IntegrationContract.View mView) {
        super(model, mView);
    }

    public void getApi(String name){
        if (TextUtils.isEmpty(name)){

        }else {

        getModel().getApi(name).subscribe(new Action1<Integration>() {
            @Override
            public void call(Integration integration) {
               if (isSuccess(integration)){
                   getView().showWeb(integration.getDocumentation_url());

               }
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(TAG, "call() called with: throwable = [" + throwable + "]");
            }
        });}
    }
    public boolean isSuccess(Integration integration){
        if (!TextUtils.isEmpty(integration.getMessage())){
            if ("Not Found".equals(integration.getMessage())){
                return true;
            }else {
                return false;
            }
        }

        return false;
    }

    public boolean isSuccess2(Integration integration) {
        if ("Not Found".equals(integration.getMessage())) {
            return true;
        } else {
            return false;
        }

    }

    public  String getPersenter(boolean isboolean){
        if (isboolean){
            System.out.println(getModel().getClass());
            return getModel().getClass().toString();
    }else{
            System.out.println(getView().getClass());
    }
        return getView().getClass().toString();
    }

}

