package com.example.linhou.testdome.jacocomodel;

import com.example.linhou.testdome.jacocomodel.model.Person;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lin.Hou on 2017/9/4.
 */
public class JacocoActivityTest {
    Person person;
    @Before
    public void setUp() throws Exception {
        person=new Person("ming",20,true);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void onCreate() throws Exception {

    }

}