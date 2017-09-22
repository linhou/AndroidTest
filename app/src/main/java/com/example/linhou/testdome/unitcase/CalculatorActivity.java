package com.example.linhou.testdome.unitcase;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.linhou.testdome.R;

/**
 * Created by Lin.Hou on 2017/8/17.
 */

public class CalculatorActivity extends AppCompatActivity{

    private EditText mEdFirst;
    private EditText mEdSecond;
    private Button mButton;
    private TextView mText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        mEdFirst= (EditText) findViewById(R.id.ed_first);
        mEdSecond= (EditText) findViewById(R.id.ed_second);
        mButton= (Button) findViewById(R.id.button);
        mText= (TextView) findViewById(R.id.lstext);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(mEdFirst.getText())&&!TextUtils.isEmpty(mEdSecond.getText())){
                    Calculator.add(Integer.parseInt(mEdFirst.getText().toString()),Integer.parseInt(mEdSecond.getText().toString()));
                }
            }
        });
    }
}
