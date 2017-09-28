package com.example.linhou.testdome.mvp;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;


import com.example.linhou.testdome.R;
import com.example.linhou.testdome.mvp.base.BaseActiviy;
import com.example.linhou.testdome.mvp.di.component.AppComponent;
import com.example.linhou.testdome.mvp.moudledi.IntegrationContract;
import com.example.linhou.testdome.mvp.moudledi.IntegrationPresenter;
import com.example.linhou.testdome.mvp.moudlemvp.DaggerIntegrationComponent;
import com.example.linhou.testdome.mvp.moudlemvp.IntergrationModule;
import com.example.linhou.testdome.robolectric.ServiceUnit;

/**
 * Created by Lin.Hou on 2017/9/13.
 */

public class IntegrationTestActivity extends BaseActiviy<IntegrationPresenter> implements IntegrationContract.View {
    private WebView mWb;
    private EditText mEd;
    private Button mBt;

    @Override
    protected void initView() {
        mEd= (EditText) findViewById(R.id.in_ed);
        mBt= (Button) findViewById(R.id.in_bt);
        mWb= (WebView) findViewById(R.id.in_wev);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: "+mEd.getText().toString());
                getPresenter().getApi(mEd.getText().toString());
            }
        });
        Intent mintent = new Intent(this, ServiceUnit.class);
        startService(mintent);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void componentInject(AppComponent appComponent) {
        DaggerIntegrationComponent.builder().appComponent(appComponent).intergrationModule(new IntergrationModule(this)).build().inject(this);
    }
    @Override
    protected int getContentViewId() {
        return R.layout.activity_integration;
    }

    @Override
    public void showWeb(String s) {
        mWb.loadUrl(s);
    }
}
