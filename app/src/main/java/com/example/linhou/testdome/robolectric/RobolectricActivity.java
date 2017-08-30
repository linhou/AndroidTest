package com.example.linhou.testdome.robolectric;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.linhou.testdome.R;

/**
 * Created by Lin.Hou on 2017/8/29.
 */

public class RobolectricActivity extends AppCompatActivity {
    private   final  String TAG="RobolectricActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roblectic);
        findViewById(R.id.robolectric_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RobolectriTwoActivity.class));
            }
        });
    }


}
