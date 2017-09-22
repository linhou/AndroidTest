package com.example.linhou.testdome.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lin.Hou on 2017/9/14.
 */

public class OrderTest2 {

    @Before
    public void beforeOne() throws Exception {
        System.out.println("OrderTest：beforeOne");
    }

    @Before
    public void one() throws Exception {
        System.out.println("OrderTest：one");
    }
    @Before
    public void AfterOne() throws Exception {
        System.out.println("OrderTest：AfterOne");
    }

    @Before
    public void three() throws Exception {
        System.out.println("OrderTest：three");
    }

    @After
    public void two() throws Exception {
        System.out.println("OrderTest：two");
    }
    @After
    public void afterTwo() throws Exception {
        System.out.println("OrderTest：afterTwo");
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
