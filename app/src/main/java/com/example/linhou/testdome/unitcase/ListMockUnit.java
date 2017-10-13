package com.example.linhou.testdome.unitcase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin.Hou on 2017/10/12.
 */

public class ListMockUnit {
    private List list;
    private ArrayList arrayList;

    public ListMockUnit(List list) {
        this.list = list;
    }

    public ListMockUnit(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public int getListSize() {
        return list.size();
    }
    public int getListSize1() {
        return arrayList.size();
    }

    public void addListSingle(){
        list.add("String");
    }
    public void addListSingle1(){
        arrayList.add("String");
    }
}
