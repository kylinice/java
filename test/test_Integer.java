package test;

public class test_Integer {
    public static void main(String[] args) {
        Integer i1 = 59;
        int i2 = 59;
        Integer i3 = Integer.valueOf(59);
        Integer i4 = new Integer(59);



        Integer a1 = 128;
        int a2 = 128;
        Integer a3 = Integer.valueOf(128);
        Integer a4 = new Integer(128);
        System.out.println(i1 == i2);//true
        System.out.println(i1 == i3);//true
        System.out.println(i1 == i4);//false
        System.out.println(i2 == i3);//true
        System.out.println(i2 == i4);//true
        System.out.println(i3 == i4);//false
        System.out.println();
        System.out.println(a1 == a2);//true
        System.out.println(a1 == a3);//false
        System.out.println(a1 == a4);//false
        System.out.println(a2 == a3);//true
        System.out.println(a2 == a4);//true
        System.out.println(a3 == a4);//false
        /*
i1==i2 true   i02 是int类型(基本类型)，和i01(包装类型)比较，i01会自动拆箱为基本类型 再比较值是否相等
i1==i3 true   都指向IntegerCache[59-(-128)]对象
i3==i4 false  引用指向的对象地址不同
i4==i2 true   i02 是int类型(基本类型)，和i04(包装类型)比较，i04会自动拆箱为基本类型 再比较值是否相等
         */
    }
}
