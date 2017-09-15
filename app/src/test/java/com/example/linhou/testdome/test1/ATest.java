package com.example.linhou.testdome.test1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/9/14.
 */
public class ATest {
    @Spy
    B b;
    @Mock
    A a;

    private A a1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
       a1=new A(b);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void setA() throws Exception {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(a1.setA());
       assertEquals("this",a1.setA());
       assertEquals("aaaaa",a1.setB());



    }

}