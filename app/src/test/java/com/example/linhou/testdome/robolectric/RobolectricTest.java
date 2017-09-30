package com.example.linhou.testdome.robolectric;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;

import com.example.linhou.testdome.BuildConfig;
import com.example.linhou.testdome.MyApplication;
import com.example.linhou.testdome.R;
import com.example.linhou.testdome.SharedPreferencesUtils;
import com.example.linhou.testdome.mvp.app.App;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;
import org.w3c.dom.Text;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Lin.Hou on 2017/8/29.
 * $MODULE_DIR$
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,application = MyApplication.class)
public class RobolectricTest {
    @Test
    public void buttonOnclick() throws Exception{
        RobolectricActivity activity = Robolectric.setupActivity(RobolectricActivity.class);
        Button button = (Button) activity.findViewById(R.id.robolectric_button);
        button.performClick();
        ShadowActivity shadowsActivity = Shadows.shadowOf(activity);
        Intent nextActivity = shadowsActivity.getNextStartedActivity();
        ShadowIntent shadowsIntents = Shadows.shadowOf(nextActivity);
        Assert.assertEquals(RobolectriTwoActivity.class,shadowsIntents.getIntentClass());
    }
    @Test
    public void lifecycle() throws Exception{
        Activity activity = Robolectric.buildActivity(RobolectriTwoActivity.class).create().get();
        TextView textView=activity.findViewById(R.id.robolectric_text);
        Assert.assertEquals("onCreate",textView.getText().toString());
        Activity activity1 = Robolectric.buildActivity(RobolectriTwoActivity.class).create().start().get();
        TextView textView1=activity1.findViewById(R.id.robolectric_text);
        Assert.assertEquals("onStart",textView1.getText().toString());
    }
    @Test
    public void testSharepreference() throws Exception{
        Application application = RuntimeEnvironment.application;
        SharedPreferences sp = application.getApplicationContext().getSharedPreferences("example", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=   sp .edit();
        editor.putString("SAMPLE_DATA", "sample data");
        editor.apply();
        assertEquals("sample data",sp.getString("SAMPLE_DATA", ""));
    }
    @Test
    public void testRes() throws  Exception{
        Context context = RuntimeEnvironment.application;
        assertThat(context.getString(R.string.app_name)).isEqualTo("TestDome");
    }
    @Test
    public void testService() throws Exception{
        RobolectricActivity activity = Robolectric.setupActivity(RobolectricActivity.class);
        Intent intent=new Intent(activity.getApplicationContext(),ServiceUnit.class);
        activity.getApplicationContext().startService(intent);
        SharedPreferences preferences =  activity.getApplicationContext()
                .getSharedPreferences("example", Context.MODE_PRIVATE);
        assertEquals( "王五",preferences.getString("id","王四"));
    }




}
