package com.example.linhou.testdome.unitcase;

import com.example.linhou.testdome.unit.A;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.linhou.testdome.unitcase.NotNullNumber.notNullNumber;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.array;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.endsWith;
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
        calculator = new Calculator();

    }

    @After
    public void tearDown() throws Exception {
        calculator = null;
    }

    @Test
    public void correctadd() throws Exception {
        //有返回值的单元测试，只有期望结果和真是结果
        assertEquals(3, Calculator.add1(1, 2));
        int addNumber = Calculator.add(1, 2);
        assertEquals(3, addNumber);
        assertEquals(3, Calculator.add(1, 2));
        assertEquals(Calculator.add(1, 2), 3);
        //可以在使用三个参数的方法，最后一个参数是范围值,期望值与实际值相减取绝对值，是否在0到范围值的范围内。
        assertEquals(2, Calculator.add(1, 2), 1);
        //double类型
        assertEquals(3.5, Calculator.add(1.5, 2.5), 1.0);

        boolean isboolean = true;
        assertTrue(isboolean);

        String s = "sssss";
        assertNotNull(s);

        String b = null;
        assertNull(b);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("String:" + i);
        }
        assertThat(list.size(), equalTo(5));
        assertThat(list.size(), is(5));
    }

    @Test
    public void erroradd() throws Exception {
        assertEquals(3, Calculator.add1(2, 2));
        assertEquals(5, Calculator.add(1, 2), 1);
        //double类型
        assertEquals(4.5, Calculator.add(1.5, 2.5), 1.0);

        assertTrue(false);

        String s = null;
        assertNotNull(s);

        String b = "ssss";
        assertNull(b);

    }

    @Test
    public void correctAssume() throws Exception {
        assumeTrue(true);//如果判断假设成功就会继续执行，失败将结束执行并忽略此测试函数
        System.out.println("sssss");
    }

    @Test
    public void errorAssume() throws Exception {
        assumeTrue(false);
        System.out.println("sssss");
    }


    //@Ignore 这个注解的作用：某个方法没有完成逻辑，加入这个注解就可以将这个测试暂时略过
    @Ignore
    @Test
    public void add1() throws Exception {
        assertEquals(3, Calculator.add(2, 2));
    }

    @Test(timeout = 1000)
    public void correctTime() throws Exception {
        int i = 0;
        while (i < 5) {
            i++;
        }
    }

    @Ignore  //测试jacoco的命令时专门注释的
    //超时的操作
    @Test(timeout = 1000)
    public void errorTime() throws Exception {
        while (true) ;
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void correctExpectd() throws Exception {
        List list = new ArrayList();
        list.get(0);
    }


    //java.lang.AssertionError: Expected exception: java.lang.IndexOutOfBoundsException
    @Test(expected = IndexOutOfBoundsException.class)
    public void errorExpectd() throws Exception {
        List list = new ArrayList();
        list.add("ssss");
        list.get(0);
    }

    //assert的方法中不仅是两个参数，还有三个参数，三个参数是：错误信息输出，期望值，实际值，但是这个错误信息输出必须要在错误的情况下才会显示


    @Test
    public void someassertforArrayEquals() throws Exception {
        //Assert有很多方法进行比较
        //比较两个数组的长度是否相等，除了比较byte数组还可以比较Int数组，long数组等等
        byte[] byte1 = new byte[5];
        byte[] byte2 = new byte[5];
        assertArrayEquals(byte1, byte2);
    }

    @Test
    public void someassertforEquals() throws Exception {
        //Assert有很多方法进行比较
        //判断两个数值或字符串是否有一致,可以传递double，int，string,object等
        assertEquals(1, 1);
        assertEquals("aa", "aa");
        assertEquals(Calculator.getInstance(), Calculator.getInstance());

        assertEquals("这不是同一个内容", "aaa", "aa");
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
        assertNotSame(Calculator.getInstance(), new Calculator());
        assertSame(Calculator.getInstance(), Calculator.getInstance());

    }

    @Test
    public void errorSomeassertforNotSame() throws Exception {
        assertNotSame(Calculator.getInstance(), Calculator.getInstance());
        assertSame(Calculator.getInstance(), new Calculator());
    }

    //assertThat,这个和上面的还有些不太一样，最后一个参数是表达式
    //区分assertEquals等，上述的内容第二个参数不是表达式，所以比较的时候回有问题，  assertEquals(true,is(true));，虽然书写的时候不报错，但是运行的时候必然报错
    //is和equalTo是hamcrest库下面的，是一种表达式。
    //hamcrest是协助编写java测试进行软件测试的框架。可以组合匹配器的灵活表达式
    @Test
    public void correctSomeassertforThat() throws Exception {
        //is()是替代了is(equalTo ())
        assertThat(true, is(3 < 4));//但是实际用到的还是is（equalTo（））方法
        assertThat(true, equalTo(3 < 4));//equalTo 匹配对象
        //可以传入三目表达式
        assertThat("true", equalTo((3 < 4)?"true":"false"));
        assertThat("true", is((3 < 4)?"true":"false"));
    }
    //当然在hamcrest还有些重要库，比如：
    // anything - 总是匹配,如果你不关心测试下的对象是什么是有用的,用处在哪？
    //    allOf - 如果所有匹配器都匹配才匹配,  理解为Java &&
//    anyOf - 如果任何匹配器匹配就匹配,理解为 Java ||
//    not - 如果包装的匹配器不匹配器时匹配,反之亦然
    //hasToString - 测试Object.toString方法,首先测试类里面必须有toString方法，这个测试不经常用到。
    @Test
    public void someassertforThat() throws Exception {
        assertThat(true, is(anything()));
        assertThat(true, allOf(is(3 < 4), is(5 < 6)));
        assertThat(true, anyOf(is(3 < 4), is(5 > 6)));
        assertThat(true, not(is(3 > 4)));
        assertThat("Calculator{}", hasToString(Calculator.getInstance().toString()));
    }

    //    equalToIgnoringCase - 测试字符串相等忽略大小写
//    equalToIgnoringWhiteSpace - 测试字符串忽略空白,会忽略多个空格等，一定会忽略开头和结尾的空格
//    containsString, endsWith, startsWith - 测试字符串匹配,使用start和end的时候必须不能带有空格
    @Test
    public void someassertforThat1() throws Exception {
        assertThat("fStrings", equalToIgnoringCase("fstrings"));
        assertThat("    I\nam hou   ", equalToIgnoringWhiteSpace("I am  hou"));
        assertThat("    I\tam hou   ", equalToIgnoringWhiteSpace("I am  hou"));
        assertThat("    I\tam hou   ", containsString("am"));
        assertThat("I\tam hou", startsWith("I"));
        assertThat("I\tam hou", Matchers.endsWith("u"));
    }

    //和Rule不同，这个需要的时候才用，
    @Test
    public void someassertforThat2() throws Exception {
        assertThat(true, is(notNullNumber(0)));

    }



}