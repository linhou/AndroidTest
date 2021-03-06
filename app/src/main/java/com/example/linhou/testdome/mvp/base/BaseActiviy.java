package com.example.linhou.testdome.mvp.base;

import com.delta.commonlibs.base.mvp.BasePresenter;
import com.example.linhou.testdome.mvp.di.component.AppComponent;


import javax.inject.Inject;

/**
 * Created by V.Wenju.Tian on 2016/11/29.
 */

public abstract class BaseActiviy<p extends BasePresenter> extends BaseCommonActivity {

    public final String TAG = getClass().getSimpleName();
    @Inject
    protected p mPresenter;

    @Override
    protected void initCView() {
        initView();
    }

    protected abstract void initView();

    @Override
    protected void initCData() {
        componentInject(getMApplication().getAppComponent());//依赖注入
        initData();
    }

    protected abstract void initData();


    @Override
    protected int getContentViewId() {
        return 0;
    }

    protected abstract void componentInject(AppComponent appComponent);


    public p getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.ondestory();
        }
        super.onDestroy();
    }
}
