package com.example.linhou.testdome.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lin.Hou on 2017/9/14.
 */

public class OrderTest1 {
    @Before
    public void one() throws Exception {
        System.out.println("OrderTest：one");
    }

    @After
    public void two() throws Exception {
        System.out.println("OrderTest：two");
    }
    @Test
    public void order() throws Exception{
        System.out.println("OrderTest：order");
    }
    @Test
    public void order1() throws Exception{
        System.out.println("OrderTest：order1");
    }
}
