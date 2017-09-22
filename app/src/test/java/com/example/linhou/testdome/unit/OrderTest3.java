package com.example.linhou.testdome.unit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by Lin.Hou on 2017/9/14.
 */

public class OrderTest3 {
    //  BeforeClassh 和Before 不一样，首先BeforeClass只执行一遍，其次在所有函数都执行前执行，最后使用这个注解的时候需要加static关键字
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("OrderTest：BeforeClass");
    }

    @BeforeClass
    public static void beforeClass1() throws Exception {
        System.out.println("OrderTest：BeforeClass1");
    }
    @Before
    public void one() throws Exception {
        System.out.println("OrderTest：one");
    }


    @After
    public void two() throws Exception {
        System.out.println("OrderTest：two");
    }
    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("OrderTest：afterClass");
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
