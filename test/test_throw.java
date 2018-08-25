package test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class test_throw implements Cloneable{
    private static void calculate(){
        int i = 8;
        int j = 0;
        Integer x = 222;
    }
    @Override
    public Object clone(){
        test_throw t = null;
        try{
            t = (test_throw)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return t;
    }
    public static void main(String[] args) throws CloneNotSupportedException{
        calculate();
        test_throw test = new test_throw();
        SoftReference sr = new SoftReference(test);
        ReferenceQueue queue=new ReferenceQueue();
        PhantomReference pr=new PhantomReference(test, queue);
        System.out.println(pr);
    }
}
