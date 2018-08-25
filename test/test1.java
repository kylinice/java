package test;

public class test1 {
    private int test_int = 1;
    public static boolean isAdmin(String admin){
        System.out.println(admin.toLowerCase());
        return admin.toLowerCase().equals("admin");
    }
    public static void main(String[] args) {
        test1 test = new test1();
        System.out.println(test.test_int);
        String s = "hello";
        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s==t);
        System.out.println(s.equals(t));
        System.out.println(s.equals(c));
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(t));

        short a = 128;
        byte b = (byte)a;
        System.out.println(Short.toString(a) + '~' + Byte.toString(b));
        System.out.println("test Integer");
        Integer int1 = 127;
        Integer int2 = 126;
        System.out.println(int2 <= int1);
        System.out.println(int2.compareTo(int1)==-1);

        int x=20;
        int y=5;
        System.out.println(x+y+"");
        System.out.println(isAdmin("Admin"));
        System.out.println(5>>2);
        System.out.println(1<<2);
        System.out.println(1&5);
        System.out.println(5>>>2);
    }
}
