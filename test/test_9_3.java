package test;
import java.util.*;

//面试宝典第九章第三个例题
public class test_9_3 {
    private String value = null;
    public test_9_3(String v){
        value = v;
    }
    public boolean equals(test_9_3 o){
        if(o == this){
            return true;
        }
        if(o instanceof test_9_3){
            System.out.println(this);
            System.out.println(o);
            test_9_3 test = (test_9_3) o;
            return value.equals(test.value);
        }
        return false;
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        test_9_3 test1 = new test_9_3("object");
        test_9_3 test2 = new test_9_3("object");
        test_9_3 test3= new test_9_3("object");
        Object test4 = new test_9_3("object");
        list.add(test1);
        System.out.println(list.contains(test2));
        System.out.println(test2.equals(test3));
        System.out.println(test3.equals(test4));
    }
}
