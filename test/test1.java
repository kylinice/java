package test;

public class test1 {
    public static void main(String[] args) {
        String s = "hello";
        String t = "hello";
        char c[] = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(s==t);
        System.out.println(s.equals(t));
        System.out.println(s.equals(c));
        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode(t));
    }
}
