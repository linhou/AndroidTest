package com.example.linhou.testdome.test1;

/**
 * Created by Lin.Hou on 2017/9/14.
 */

public class A {
    private  B b;
    private String stringa="this";

    public A(){

    }
    public A(B b) {
        this.b = b;
    }

    public String setA(){
      return stringa;
    }
    public String setB(){
        return b.stringb;
    }
}
