package com.example.linhou.testdome.unitcase;

/**
 * Created by Lin.Hou on 2017/9/28.
 */

public class SpyUnit4 {
    public void setSpyA(int a){
        Calculator.getInstance().setA(a);
    }
}
