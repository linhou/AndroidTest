package com.example.linhou.testdome.unitcase;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Lin.Hou on 2017/9/25.
 */
//书写定制匹配

public class NotNullNumber extends TypeSafeMatcher<Double> {
    private final Double mNumber;
    //第一步要继承TypeSafeMatcher,在泛型中加入类型

    public NotNullNumber(Double number){
       this.mNumber=number;
    }
    //第二步进行验证，false就是错误的，会提供错误信息
    @Override
    protected boolean matchesSafely(Double item) {
        if (mNumber==0){
            return false;
        }
        return true;
    }
    //添加错误信息。
    @Override
    public void describeTo(Description description) {
        description.appendText("这是一个错误信息");
    }
    //第三步封装工厂模式。
    //使用工厂模式，可以最快使用,假如这个需要添加参数，那么就需要构造函数。
    @Factory
    public static Matcher notNullNumber(double number) {
        return new NotNullNumber(number);
    }


}
