package com.example.linhou.testdome.unitcase;

import com.example.linhou.testdome.mvp.entity.Integration;
import com.example.linhou.testdome.mvp.moudledi.IntegrationPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import rx.Observable;
import rx.functions.Action1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by Lin.Hou on 2017/9/28.
 */

public class InjectMockTest {


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

    }

    @After
    public void tearDown() throws Exception {


    }

    @Test
    public void getModle() throws Exception {

    }
}