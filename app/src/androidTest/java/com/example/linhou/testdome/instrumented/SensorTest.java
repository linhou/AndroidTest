package com.example.linhou.testdome.instrumented;

import android.os.Build;
import android.support.test.BuildConfig;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Lin.Hou on 2017/9/27.
 */
@RunWith(AndroidJUnit4.class)
public class SensorTest {

    @Test
    public  void version() throws Exception{
        assertEquals(24, Build.VERSION.SDK_INT);
    }
}
