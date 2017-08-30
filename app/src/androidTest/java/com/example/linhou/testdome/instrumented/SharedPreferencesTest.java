package com.example.linhou.testdome.instrumented;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.RequiresDevice;
import android.support.test.runner.AndroidJUnit4;

import com.example.linhou.testdome.SharedPreferencesUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lin.Hou on 2017/8/23.
 */
@RunWith(AndroidJUnit4.class)
public class SharedPreferencesTest {
    final  String SHANENAME="sp_demo";
    Context context = InstrumentationRegistry.getTargetContext();
    SharedPreferences sp = context.getSharedPreferences(SHANENAME, Context.MODE_PRIVATE);
    private SharedPreferences.Editor shared =sp.edit();

    @Test
    public void sharedTest()throws Exception{
        shared .putString("name", "小张");
        shared .putInt("age", 11);
        shared.commit();
        assertEquals("小张",sp.getString("name",null));
        assertEquals(11,sp.getInt("age",0));
    }

    @Test
    public void sharedutilsTest() throws Exception{
        Context scontext = InstrumentationRegistry.getTargetContext();
        SharedPreferencesUtils.getInstance(scontext).setUserId("10");
        assertEquals("10",SharedPreferencesUtils.getUserId());
    }
    @Test
    @RequiresDevice
    public void sharedutilsTestDevice() throws Exception{
        Context scontext = InstrumentationRegistry.getTargetContext();
        SharedPreferencesUtils.getInstance(scontext).setUserId("10");
        assertEquals("10",SharedPreferencesUtils.getUserId());
    }

}
