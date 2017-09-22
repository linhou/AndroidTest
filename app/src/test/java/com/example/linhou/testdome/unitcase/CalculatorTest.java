package com.example.linhou.testdome.unitcase;

import com.example.linhou.testdome.unit.A;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
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
    public void correctadd() throws Exception {
        //有返回值的单元测试，只有期望结果和真是结果
        assertEquals(3,Calculator.add1(1,2));
        int addNumber = Calculator.add(1, 2);
        assertEquals(3,addNumber);
        assertEquals(3,Calculator.add(1,2));
        assertEquals(Calculator.add(1,2),3);
        //可以在使用三个参数的方法，最后一个参数是范围值,期望值与实际值相减取绝对值，是否在0到范围值的范围内。
        assertEquals(2,Calculator.add(1,2),1);
        //double类型
        assertEquals(3.5,Calculator.add(1.5,2.5),1.0);

        boolean isboolean=true;
        assertTrue(isboolean);

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

    @Test
    public void erroradd() throws Exception {
        assertEquals(3,Calculator.add1(2,2));
        assertEquals(5,Calculator.add(1,2),1);
        //double类型
        assertEquals(4.5,Calculator.add(1.5,2.5),1.0);

        assertTrue(false);

        String s=null;
        assertNotNull(s);

        String b = "ssss";
        assertNull(b);

    }

    @Test
    public  void correctAssume() throws Exception{
        assumeTrue(true);//如果判断假设成功就会继续执行，失败将结束执行并忽略此测试函数
        System.out.println("sssss");
    }

    @Test
    public  void errorAssume() throws Exception{
        assumeTrue(false);
        System.out.println("sssss");
    }


    //@Ignore 这个注解的作用：某个方法没有完成逻辑，加入这个注解就可以将这个测试暂时略过
    @Ignore
    @Test
    public void add1() throws Exception{
        assertEquals(3,Calculator.add(2,2));
    }

    @Test(timeout = 1000)
    public void correctTime() throws Exception {
        int i=0;
        while (i<5){
            i++;
        }
    }
    @Ignore  //测试jacoco的命令时专门注释的
    //超时的操作
    @Test(timeout = 1000)
    public void errorTime() throws Exception {
      while (true);
    }




    @Test( expected =IndexOutOfBoundsException.class)
    public void correctExpectd() throws Exception{
        List list=new ArrayList();
        list.get(0);
    }


    //java.lang.AssertionError: Expected exception: java.lang.IndexOutOfBoundsException
    @Test( expected =IndexOutOfBoundsException.class)
    public void errorExpectd() throws Exception{
        List list=new ArrayList();
        list.add("ssss");
        list.get(0);
    }

    //assert的方法中不仅是两个参数，还有三个参数，三个参数是：错误信息输出，期望值，实际值，但是这个错误信息输出必须要在错误的情况下才会显示



    @Test
    public void someassertforArrayEquals() throws Exception {
        //Assert有很多方法进行比较
        //比较两个数组的长度是否相等，除了比较byte数组还可以比较Int数组，long数组等等
        byte[] byte1=new byte[5];
        byte[] byte2=new byte[5];
        assertArrayEquals(byte1,byte2);
    }

    @Test
    public void someassertforEquals() throws Exception {
        //Assert有很多方法进行比较
        //判断两个数值或字符串是否有一致,可以传递double，int，string,object等
        assertEquals(1,1);
        assertEquals("aa","aa");
        assertEquals(Calculator.getInstance(),Calculator.getInstance());

        assertEquals("这不是同一个内容","aaa","aa");
    }
    @Test
    public void someassertforBoolean() throws Exception {
        //Assert有很多方法进行比较
        //判断条件的真假
        boolean isBoolean = true;
       assertTrue(isBoolean);
        assertTrue("这是一个内容", false);
//       assumeFalse(isBoolean);

    }

    //判断是否是相同的对象，assertNotSame必须不是相同的对象，assertSame必须是相同的对象
    @Test
    public void correctSomeassertforNotSame() throws Exception {
        assertNotSame(Calculator.getInstance(),new Calculator());
        assertSame(Calculator.getInstance(),Calculator.getInstance());

    }
    @Test
    public void errorSomeassertforNotSame() throws Exception {
        assertNotSame(Calculator.getInstance(),Calculator.getInstance());
        assertSame(Calculator.getInstance(),new Calculator());
    }
    //assertThat,这个和上面的还有些不太一样，最后一个参数是表达式
    //is和equalTo是hamcrest库下面的
    @Test
    public void someassertforThat() throws Exception {
        assertThat(true,is(3<4));
        assertThat(true,equalTo(3<4));

    }
}