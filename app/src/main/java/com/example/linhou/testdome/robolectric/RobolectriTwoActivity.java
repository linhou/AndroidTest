package com.example.linhou.testdome.robolectric;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.linhou.testdome.R;

/**
 * Created by Lin.Hou on 2017/8/29.
 */

public class RobolectriTwoActivity extends AppCompatActivity{
    private TextView text;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        text= (TextView) findViewById(R.id.robolectric_text);
        text.setText("onCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        text.setText("onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        text.setText("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        text.setText("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        text.setText("onDestroy");
    }
}
