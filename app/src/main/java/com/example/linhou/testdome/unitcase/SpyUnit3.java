package com.example.linhou.testdome.unitcase;

/**
 * Created by Lin.Hou on 2017/9/28.
 */

public abstract class SpyUnit3 {
    public void add(){
        System.out.println(" this is add");
    }
    public int adds(int a, int b){
        return a+b;
    }
    public abstract void addAbstract();
}
