package com.example.linhou.testdome.test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

/**
 * Created by Lin.Hou on 2017/9/14.
 */

public class OrderTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("1");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("3");
    }
    @Test
    public void order() throws Exception{
        System.out.println("2");
    }
}
