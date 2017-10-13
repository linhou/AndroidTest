package com.example.linhou.testdome.unitcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anySetOf;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/9/22.
 */

public class MockTestUnit {

    @Mock
    List list;
    @Spy
     ArrayList arrayList;


    //@InjectMocks
    ListMockUnit listMockUnit;
    ListMockUnit listMockUnit1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        listMockUnit=new ListMockUnit(list);
        listMockUnit1=new ListMockUnit(arrayList);


    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void  getListSizeTest() throws Exception{
       when(list.size()).thenReturn(10);
//        System.out.println(listMockUnit.getListSize());
        assertEquals(10,listMockUnit.getListSize());
    }

    @Test
    public void addListSingleTest() throws Exception{
        listMockUnit.addListSingle();
//        System.out.println("------");
        verify(list).add("String");
//        System.out.println("------");
    }

    @Test
    public void getListSizeTest1() throws  Exception{
        when(arrayList.size()).thenReturn(10);
        assertEquals(10,listMockUnit1.getListSize1());
    }

}
