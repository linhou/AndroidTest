package com.example.linhou.testdome.unitcase;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Lin.Hou on 2017/9/1.
 */

public class JunitRuleTest implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                //在测试方法之前做一些事情
                String className = description.getClassName();
                String methodName = description.getMethodName();
                System.out.println("JunitRuleTest:"+className);
                System.out.println("JunitRuleTest:"+methodName);
                //运行测试方法
                base.evaluate();
                //测试方法运行之后的事情
                System.out.println("JunitRuleTest  after: "+className +", :"+methodName+"\n");
            }
        };
    }


}
