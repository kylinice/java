package test;

import javax.swing.plaf.synth.SynthDesktopIconUI;

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

        short a = 128;
        byte b = (byte)a;
        System.out.println(Short.toString(a) + '~' + Byte.toString(b));
        System.out.println("test Integer");
        Integer int1 = 127;
        Integer int2 = 126;
        System.out.println(int2 <= int1);
        System.out.println(int2.compareTo(int1)==-1);

    }
}
