package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TestClass {
    private static void testMethod(){
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        ((TestClass)null).testMethod();
        System.out.println(3^4^5^6^4^3);
        List<Integer> list = new ArrayList<>();
        list.add(12);
//这里直接添加会报错
        //list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = null;
        try {
            add = clazz.getDeclaredMethod("add", Object.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
//但是通过反射添加，是可以的
        try {
            add.invoke(list, "kl");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(list);
    }
}
