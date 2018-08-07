package test;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPoolOOM {
    //使用List保持着常量池引用，避免Full GC回收常量池行为

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //10M的PermSize在Integer范围内足够产生OOM了
        int i=0;
        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern()==str1);
        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }
}
