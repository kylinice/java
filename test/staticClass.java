package test;

public class staticClass {
    public static staticClass t1 = new staticClass();
    public static staticClass t2 = new staticClass();
//    staticClass(){
//        System.out.println("构造函数");
//    }
    {
        System.out.println("构造块");
    }
    static {
        System.out.println("静态块");
    }

    public static void main(String[] args) {
        staticClass t = new staticClass();
    }
}

