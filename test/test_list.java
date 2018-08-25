package test;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class test_list {
    static int x=10;
    static {
        x = x+5;
        System.out.println(x);
    }
    static{
        x/=2;
        System.out.println(x);
    }
    public static void doSomething(Integer integer){
        integer = new Integer(2);
    }
    public static void main(String[] args) {
        List<Integer> NumberList = new ArrayList<Integer>();
        NumberList.add(2);
        NumberList.add(4);
        NumberList.add(1);
        NumberList.add(3);
        NumberList.add(5);
        for(int i =0;i<NumberList.size();++i){
            int v = NumberList.get(i);
            if(v%2==0){
                NumberList.remove((Integer)v);
            }
        }
        System.out.println(NumberList);
        System.out.println(x);
        Integer var1 = new Integer(1);
        Integer var2 = var1;
        doSomething(var2);
        System.out.println(var1.intValue());
        System.out.println(var1==var2);
    }
}
