package com.example.linhou.testdome.unitcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

/**
 * Created by Lin.Hou on 2017/9/30.
 */
public class SpyUnitTest {




    int a=0;

    @Spy
    SpyUnit spyUnit=new SpyUnit(a);

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void add() throws Exception {
        doReturn(6).when(spyUnit).add(2,3);
        assertEquals(10,  spyUnit.add(2,3));
    }
    @Test
    public void addc() throws Exception {
        doReturn(6).when(spyUnit).addc(3);
        assertEquals(10,  spyUnit.addc(3));
    }

}