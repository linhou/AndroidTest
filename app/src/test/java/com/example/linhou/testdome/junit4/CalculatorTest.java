package com.example.linhou.testdome.junit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.verification.Timeout;
import org.mockito.verification.VerificationMode;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.describedAs;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/8/17.
 */
public class CalculatorTest {



    @Mock
    List list;
    @Spy
    ArrayList spyList;

    @Mock
    Calculator calculator1;
    @Spy
    Calculator calculator2;

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
        assertEquals(3,Calculator.add1(1,2));
        int addNumber = Calculator.add(1, 2);
        assertEquals(3,addNumber);
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

    //@Ignore//测试jacoco的命令时专门注释的
    //超时的操作
    @Test(timeout = 1000)
    public void add2() throws Exception {
      while (true);
    }





    @Test( expected =IndexOutOfBoundsException.class)
    public void index() throws Exception{
        List list=new ArrayList();
        list.get(0);
    }



    @Test
    public void mocktest4() throws Exception{
        //doThrow(new RuntimeException()).when(list).clear()：如果仅仅这个方法的话，调用这个函数就会报错
        //但是加入doNoting就会发现没有报错
        doNothing().doThrow(new RuntimeException()).when(list).clear();
        list.clear();
    }

   // @Ignore//测试jacoco的命令时专门注释的
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
       //verify(list,times(2)).add("String2");
        verify(list,never()).add("String10");//从来没有发生过
        verify(list,atLeast(1)).add("String1");//最少被调用一次，最少调用次数
        verify(list,atMost(2)).add("String1");//最多被调用2次，最多调用次数


    }

    //@Ignore //测试jacoco的命令时专门注释的
    @Test
    public void mocktest7() throws Exception{
      when(list.get(0)).thenReturn("String");
      System.out.println(list.get(0));
       when(spyList.get(0)).thenReturn("String");
        System.out.println(spyList.get(0));
    }

    @Test
    public void mocktest8() throws Exception{
        doReturn("String").when(spyList).get(0);
        //when(spyList.get(0)).thenReturn("String");
        System.out.println(spyList.get(0));

    }

    @Test
    public void mocktest9() throws Exception{
        //不明白为什么，运行真实的方法
        //doCallRealMethod().when(calculator2).soutadd(1,2);
        doCallRealMethod().when(calculator1).soutadd(1,2);
        assertEquals("输出结果是：3",calculator2.soutadd(1,2));
    }

    @Test
    public void mocktest10() throws Exception{
        list.get(0);
        list.get(0);
        verify(list,timeout(1).times(2)).get(0);

    }

    @Test
    public void mocktest11() throws Exception{
        list.add("one");
        list.add("two");
        verify(list).add("one");
        verify(list).add("two");
        verifyNoMoreInteractions(list);

    }
    @Test
    public void mocktest12() throws Exception{
        //list.add("one");
        verifyZeroInteractions(list);

    }
    @Test
    public void mocktest13() throws Exception{
        list.size();
        verify(list).size();

    }

}