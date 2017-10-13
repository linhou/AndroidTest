package com.example.linhou.testdome.unitcase;

import android.util.Log;

/**
 * Created by Lin.Hou on 2017/9/28.
 */

public class SpyUnit  {
    private static final String TAG ="SpyUnit" ;
    private  int mA;

    private SpyUnit(){

    }
SpyUnit(int a){
        this.mA=a;
    }
    public int add(int  a, int b){
        System.out.println("--------SpyUnit add()--------");
        return a+b;
    }
    public int addc(int b){
        System.out.println("--------SpyUnit addc()--------");
        return mA+b;
    }


}
