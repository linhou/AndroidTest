package com.example.linhou.testdome.instrumented;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.linhou.testdome.robolectric.ServiceUnit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Lin.Hou on 2017/9/26.
 */
@RunWith(AndroidJUnit4.class)
public class ServiceUnitTest {
    @Rule
    public  ServiceTestRule mServiceRule = new ServiceTestRule();
    @Test
    public void servicetest() throws  Exception{
        Context context = InstrumentationRegistry.getTargetContext();
        Intent intent=new Intent(context,ServiceUnit.class);
        context.startService(intent);
        SharedPreferences preferences =context
                .getSharedPreferences("example", Context.MODE_PRIVATE);
        assertEquals( "王五",preferences.getString("id","王四"));
    }


}
