package test;

public class TestClass {
    private static void testMethod(){
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        ((TestClass)null).testMethod();
        System.out.println(3^4^5^6^4^3);
    }
}
