package com.example.linhou.testdome.unitcase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lin.Hou on 2017/9/22.
 */

public class JunitRuleUnitTest {
    @Rule
    public JunitRuleTest junitRuleTest=new JunitRuleTest();

    @Test
    public void addition_isCorrect() throws Exception {

        System.out.println("JunitRuleUnitTest"+"--addition_isCorrect--");
    }
    @Test
    public void addition_isCorrect1() throws Exception {
        System.out.println("JunitRuleUnitTest"+"--addition_isCorrect1--");
    }
}
