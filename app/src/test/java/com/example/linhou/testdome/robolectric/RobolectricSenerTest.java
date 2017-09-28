package com.example.linhou.testdome.robolectric;

import android.os.Build;

import com.example.linhou.testdome.BuildConfig;
import com.example.linhou.testdome.MyApplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Lin.Hou on 2017/9/27.
 */
@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class)
@Config(constants = BuildConfig.class,sdk = 18)
//@Config(constants = BuildConfig.class,sdk = 23)
public class RobolectricSenerTest {

    @Test
    public  void version() throws Exception{
        assertEquals(24, Build.VERSION.SDK_INT);
    }
}
