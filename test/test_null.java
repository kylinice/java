package test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class test_null {
    test_null(int n){
        System.out.println("super constructor");
    }
    private String super_private = "super private";
    protected String super_protected = "super protected";
    public static void main(String[] args) throws IOException{
        test_null test = new test_null(8);
        System.out.println(test.super_private);
        String str = null;
        try{
            test();
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally {
            System.out.println("dd");
        }

    }
    static void test() throws RuntimeException{
        //throw new Exception();
    }
}

class test_subclass extends test_null{
    public String sub = "subclass";
    test_subclass(){
        super(9);
        //super();
        System.out.println(super.super_protected);
    }

    public static void main(String[] args) {
        test_null test = new test_subclass();
        System.out.println(((test_subclass) test).sub);
        System.out.println(test.getClass());
        System.out.println(test_subclass.class);
    }
}
