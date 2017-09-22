package com.example.linhou.testdome.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lin.Hou on 2017/9/14.
 */

public class OrderTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("OrderTest：setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("OrderTest：tearDown");
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
