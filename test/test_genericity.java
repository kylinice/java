package test;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test_genericity {
    public static void main(String[] args) {
        /*
        PECS（Producer Extends Consumer Super）原则:
            频繁往外读取内容的，适合用上界Extends。
            经常往里插入的，适合用下界Super。
        */
        //List<? extends Father_1> list_1 = new LinkedList<Human>(); error
        List<? extends Father_1> list = new LinkedList<Father_1>();
        List<? extends Father_1> list1 = new LinkedList<Son_1>();
        //list.add(new Son_1()); error
        Human human = list.get(0); //get只能返回Father_1和他的基类(父类)



        //Son_1 son_1 = list.get(0); error
        List<? super Father_1> list3 = new ArrayList<Human>();
        //List<? super Father_1> list4 = new ArrayList<Son_1>(); error
        //list3.add(new Human()); error
        list3.add(new Father_1());
        list3.add(new Son_1());
        list3.add(new LeiFeng());
        //Father_1 father_1 = list3.get(0); error
        //get只能返回Object
        Object obj = list3.get(0);
        /*
        总结：
        extends 可用于返回类型限定，不能用于参数类型限定（换句话说：? extends xxx 只能用于方法返回类型限定，
           jdk能够确定此类的最小继承边界为xxx，只要是这个类的父类都能接收，但是传入参数无法确定具体类型，只能接受null的传入）。
        super 可用于参数类型限定，不能用于返回类型限定（换句话说：? supper xxx 只能用于方法传参，因为jdk能够确定传入为xxx的子类，返回只能用Object类接收）。
        ? 既不能用于方法参数传入，也不能用于方法返回。
         */
    }
}
class Human{
}
class Father_1 extends Human{
}
class Son_1 extends Father_1{
}
class LeiFeng extends Father_1 {
}
