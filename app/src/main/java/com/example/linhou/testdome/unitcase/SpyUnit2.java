package com.example.linhou.testdome.unitcase;

import java.util.List;

/**
 * Created by Lin.Hou on 2017/9/28.
 */

public class SpyUnit2 {

    public void listadd(List list){
        for (int i = 0; i < 5; i++) {
            list.add("String");
        }
    }

    public int getSpyA(){
        return Calculator.getInstance().getA();
    }
}
