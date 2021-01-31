package com.atguigu.springcloud.test;

public class IntCompareDemo {
    public static void main(String[] args) {
        String a = "1111";
        String b = new String("1111");

        System.out.println(a.equals(b));
        System.out.println(a==b);

        Integer i = Integer.valueOf(12);

        System.out.println(i);
        try{
            int aa  = 10/0;
        }finally {
        }


    }
}
