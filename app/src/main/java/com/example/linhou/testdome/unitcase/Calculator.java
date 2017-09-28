package com.example.linhou.testdome.unitcase;

/**
 * Created by Lin.Hou on 2017/8/17.
 */

public class Calculator {
        private static volatile Calculator calculator;
    private int a;

    public  Calculator  (){

    }

    public static Calculator getInstance(){
        if (calculator==null){
            synchronized (Calculator.class){
                if (calculator==null){
                calculator=new Calculator();
                }
            }
        }
        return calculator;
    }
    public  static int add(int a,int b){
        return  a+b;
    }
    public static int add1(int a,int b){
        int c=a+b;
        return c;
    }
    public  static double add(double a,double b){
        return  a+b;
    }
    public  String soutadd(int a,int b){
       return "输出结果是："+(a+b);
    }
    public void sout(String s){
        System.out.println("say:"+s);
    }
    public static  int addNumber(int a,int b){
        if (a>0&&b>0){
            return a+b;
        }
        return 0;
    }

   public void setA(int a){
       this.a=a;
   }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Calculator{}";
    }
}

