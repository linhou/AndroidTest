package com.example.linhou.testdome.junit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/8/17.
 */
public class CalculatorTest {


    @Mock
    List list;

    private Calculator calculator;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        calculator=new Calculator();

    }

    @After
    public void tearDown() throws Exception {
        calculator=null;
    }

    @Test
    public void add() throws Exception {
        //有返回值的单元测试，只有期望结果和真是结果
        assertEquals(3,Calculator.add(1,2));
        assertEquals(Calculator.add(1,2),3);
        //可以在使用三个参数的方法，最后一个参数是范围值
        assertEquals(2,Calculator.add(1,2),1);
        assertEquals(4,Calculator.add(1,2),1);
       // assertEquals(5,Calculator.add(1,2),1);


        //double类型
        assertEquals(4.5,Calculator.add(1.5,2.5),1.0);
        assertEquals(3.5,Calculator.add(1.5,2.5),1.0);

        boolean isboolean=true;
        assertTrue(isboolean);
        //assertFalse(isboolean);

        String s="sssss";
        assertNotNull(s);

        String b = null;
        assertNull(b);

        List<String> list=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            list.add("String:"+i);
        }
        assertThat(list.size(),equalTo(5));
        assertThat(list.size(),is(5));
    }

    //@Ignore 这个注解的作用：某个方法没有完成逻辑，加入这个注解就可以将这个测试暂时略过
    @Ignore
    @Test
    public void add1() throws Exception{
        assertEquals(3,Calculator.add(2,2));
    }

    //超时的操作
    @Test(timeout = 1000)
    public void add2() throws Exception {
      while (true);
    }



    @Test
    public void mocktest4() throws Exception{
        //doThrow(new RuntimeException()).when(list).clear()：如果仅仅这个方法的话，调用这个函数就会报错
        //但是加入doNoting就会发现没有报错
        doNothing().doThrow(new RuntimeException()).when(list).clear();
        list.clear();
    }

    @Test
    public void mocktest5() throws Exception{
        List li=spy(List.class);
       doReturn("sss").when(li).clear();
        li.clear();
    }

    @Test
    public void mocktest6() throws Exception{
        list.add("String1");
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        list.add(anyString());
        //time的作用就是将验证这个方法调用的次数
        verify(list,times(2)).add("String1");
        verify(list,times(2)).add("String2");

    }

    @Test
    public void mocktest7() throws Exception{
        List li=spy(List.class);
        doReturn("sss").when(li).clear();
        li.clear();
    }



}