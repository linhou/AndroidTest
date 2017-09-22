package com.example.linhou.testdome.unitcase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Lin.Hou on 2017/9/22.
 */

public class JunitRuleUnitTest1 {
    //rule是高度可重用的一部分内容

    @Rule
    public JunitRuleTest junitRuleTest=new JunitRuleTest();

    @BeforeClass
    public static void Up() throws Exception{
        System.out.println("JunitRuleUnitTest1：BeforeClass");
    }

    @Before
    public void setUp() throws Exception{
        System.out.println("JunitRuleUnitTest1：Before");
    }
    @After
    public  void tearDown() throws Exception{
        System.out.println("JunitRuleUnitTest1：After");
    }

    @AfterClass
    public static void Down() throws Exception{
        System.out.println("JunitRuleUnitTest1：AfterClass");
    }
    @Test
    public void addition_isCorrect() throws Exception {

        System.out.println("JunitRuleUnitTest"+"--addition_isCorrect--");
    }
    @Test
    public void addition_isCorrect1() throws Exception {
        System.out.println("JunitRuleUnitTest"+"--addition_isCorrect1--");
    }
}
