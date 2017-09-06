package com.example.linhou.testdome.jacocomodel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.linhou.testdome.R;
import com.example.linhou.testdome.jacocomodel.model.Person;

import junit.framework.Test;

/**
 * Created by Lin.Hou on 2017/9/4.
 */

public class JacocoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jacoco);
        TextView textView= (TextView) findViewById(R.id.tv_jacoco);
        Person person=new Person("ming",20,true);
        textView.setText(person.getName()+person.getAge()+person.isGender());

    }
}
