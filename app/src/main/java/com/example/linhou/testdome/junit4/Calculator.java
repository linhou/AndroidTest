package com.example.linhou.testdome.junit4;

import android.support.v4.media.VolumeProviderCompat;

/**
 * Created by Lin.Hou on 2017/8/17.
 */

public class Calculator {

    public  static int add(int a,int b){
        return  a+b;
    }
    public static int add1(int a,int b){
        int c=a+b;
        return c;
    }
    public  static double add(double a,double b){
        return  a+b;
    }
    public  String soutadd(int a,int b){
       return "输出结果是："+(a+b);
    }
    public void sout(String s){
        System.out.println("say:"+s);
    }
}
