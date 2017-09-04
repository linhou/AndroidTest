package com.example.linhou.testdome;

import com.example.linhou.testdome.junit4.JunitRuleTest;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Rule
    public JunitRuleTest junitRuleTest=new JunitRuleTest();
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
        System.out.println("addition_isCorrect"+"----");
    }
    @Test
    public void addition_isCorrect1() throws Exception {
        System.out.println("addition_isCorrect"+"--1--");
    }
}