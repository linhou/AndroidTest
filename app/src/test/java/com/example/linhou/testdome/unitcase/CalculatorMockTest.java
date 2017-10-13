package com.example.linhou.testdome.unitcase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.cglib.proxy.Proxy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
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
 * Created by Lin.Hou on 2017/9/22.
 */

public class CalculatorMockTest {

    //Mock和Spy的区别，一个是主动性，一个是被动性的，主动性是Mock，期望调用多少次，与实际调用相比较，Spy不确定调用多少次，只能记录调用次数，传入参数等

    @Mock
    List list;

    //监视器
    @Spy
    ArrayList spyList;

    @Mock
    Calculator calculator1;
    @Spy
    Calculator calculator2;


    //以下几个是测试用的
    @Spy
    SpyUnit spyUnit;


    @Spy
    SpyUnit2 spyUnit2;
    @Mock
    SpyUnit2 mockUnit2;
    @Spy
    ArrayList  spyUnit2List;


    @Spy
    SpyUnit3 spyUnit3;

    @Spy
    Calculator spyCalculator1;
    @Spy
    Calculator spyCalculator2;



    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);


    }

    @After
    public void tearDown() throws Exception {

    }




    @Test
    public void correctMockforVerify() throws Exception{
        list.add("String1");
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        list.add(anyString());

        //验证add方法被调用
        verify(list).add("String2");
        //除了anyString还有anyChar，anyInt，anyBoolean，anyList等等
       // verify(list).add(anyString());
        //time的作用就是将验证这个方法调用的次数
        verify(list,times(2)).add("String1");
        //verify(list,times(2)).add("String2");
        verify(list,never()).add("String10");//从来没有发生过
        verify(list,atLeast(1)).add("String1");//最少被调用一次，最少调用次数
        verify(list,atMost(2)).add("String1");//最多被调用2次，最多调用次数

    }



    @Test
    public void errorMockforVerify() throws Exception{
        list.add("String1");
        list.add("String1");
        list.add("String2");
        list.add("String3");
        list.add("String4");
        list.add(anyString());
        verify(list,times(2)).add("String2");
        verify(list,never()).add("String4");
        verify(list,atMost(2)).add("String3");//最多被调用2次，最多调用次数
    }

    @Test
    public void correctMockforAny() throws Exception{
        list.add(anyString());
        //除了anyString还有anyChar，anyInt，anyBoolean，anyList等等
        verify(list).add(anyString());

    }
    @Test
    public void correctMockforAny1() throws Exception{
        list.add("ssss");
        //除了anyString还有anyChar，anyInt，anyBoolean，anyList等等
        verify(list).add(anyString());

    }


    @Test
    public void correctMockforWhen() throws Exception{
        when(list.get(0)).thenReturn("String");
        System.out.println(list.get(0));
        assertEquals("String",list.get(0));

    }

    @Test
    public void correctMockforWhen1() throws Exception{
        //因为是用@Spy注解的，所以在get（0）的是一定会数组越界，所以想要返回某个值得时候请用correctMockforSpyReturn的例子
        when(spyList.get(0)).thenReturn("String");
        System.out.println(spyList.get(0));

    }

    @Test
    public void correctMockforSpyReturn() throws Exception{
        doReturn("String").when(spyList).get(0);
        System.out.println(spyList.get(0));
    }

    @Test
    public void correctMockforSpyDoCallRealMethod() throws Exception{
        doCallRealMethod().when(calculator1).soutadd(1,2);
        assertEquals("输出结果是：3",calculator2.soutadd(1,2));
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
    public void correctMockforMockTimes() throws Exception{
        list.get(0);
        list.get(0);
        verify(list,times(2)).get(0);
    }
    @Test
    public void correctMockforMockTimeout() throws Exception{
        list.get(0);
        list.get(0);
        verify(list,timeout(1000)).get(0);
    }
    @Test
    public void correctMockforMockTimeoutAndTimes() throws Exception{
        list.get(0);
        list.get(0);
        verify(list,timeout(1000).times(2)).get(0);
    }




        //验证是否有调用，但是还没验证的方法
    @Test
    public void correctMockforMockVerifyNoMoreInteractions() throws Exception{
        list.add("one");
        list.add("two");
        verify(list).add("one");
        verify(list).add("two");
        verifyNoMoreInteractions(list);
    }

    @Test
    public void errorMockforMockVerifyNoMoreInteractions() throws Exception{
        list.add("one");
        list.add("two");
        verify(list).add("one");
        verifyNoMoreInteractions(list);
    }



    //与上述内容正好相反，验证所有mock对象所有方法都没有被调用,调用后必须被验证，否则就有问题
    @Test
    public void correctMockforMockVerifyZeroInteractions() throws Exception{
        verifyZeroInteractions(list);
    }


    @Test
    public void errorMockforMockVerifyZeroInteractions() throws Exception{
        list.add("one");
        verifyZeroInteractions(list);
    }

    @Test
    public void correctMockforMockVerifyZeroInteractions1() throws Exception{
        list.add("one");
        verify(list).add("one");
        verifyZeroInteractions(list);
    }

    @Test
    public void mockAndSpy() throws Exception{
        spyList.add(anyString());
        verify(spyList).add(anyString());

    }

    @Test
    public void comparisonMockAndSpy() throws Exception{
        System.out.println(list.get(0));

    }

    @Test
    public void comparisonMockAndSpy1() throws Exception{
        assertEquals(3,spyUnit.add(1,2));
    }

    @Test
    public void comparisonMockAndSpy2() throws Exception{
        mockUnit2.listadd(spyUnit2List);
        verify(spyUnit2List,times(5)).add("String");
        System.out.println("-------------------------");
        spyUnit2.listadd(spyUnit2List);
        verify(spyUnit2List,times(5)).add("String");
        System.out.println("---------------------");
    }

    @Test
    public void comparisonClassAndSpy3() throws Exception{
        spyUnit3.add();
        verify(spyUnit3).add();
        assertEquals(3,spyUnit3.adds(1,2));

    }

    @Test
    public void comparisonClassAndSpy4() throws Exception{
        //mock通过动态代理的方式生成对象，但是这个对象有不是真实的对象。
        System.out.println(spyCalculator1.getClass().getName());
        System.out.println(spyCalculator1.hashCode());
        System.out.println(spyCalculator2.hashCode());
        spyCalculator1.setA(1);
        assertEquals(1,spyCalculator2.getA());
    }

    @Test
    public void comparisonClassAndSpy5() throws Exception{
        assertEquals(1,spyCalculator1.getA());
    }


}
