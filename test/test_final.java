package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test_final {
    private final String str = new String("java");
    private static final String message = "taobao";
    //private final String str = "yes";
    private void test(){
        System.out.println("test");
    }
    public static void main(String[] args) throws Exception {
        test_final test = new test_final();
        Field field = test.getClass().getDeclaredField("str");
        field.setAccessible(true);
        field.set(test, "no");
        System.out.println(test.str);
        //test.str = "string";
        //System.out.println(test.str);
        Class test_class = Class.forName("test.test_final");
        test_final test1 = (test_final) test_class.newInstance();
        Field field1 = test1.getClass().getDeclaredField("str");
        field1.setAccessible(true);
        field1.set(test1, "yes_1");
        System.out.println(test1.str);
        String a = "tao" + "bao";
        String b = "tao";
        String c = "bao";
        System.out.println(a==message);
        System.out.println((b+c)==message);
    }
}
