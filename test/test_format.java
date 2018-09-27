package test;

public class test_format {
    public static void main(String[] args) {
        byte a=1,b=1, c=1;
        final byte d=3, e;
        double aa=1, bb=2, cc=3;
        float dd = (float) (aa+bb);
        e = (byte)(a+b);
        System.out.println(e);
        double n1 = 10e9;
        String n2 = "hello";
        double n3 = 9;
        double n4 = 0b11001_001_0_0_11;//二进制 3219.0
        double n5 = 9.88;
        // #表示前面加上0x; 010表示%左边总共10个字符，向右靠齐，左边用0补齐
        System.out.println(n4);//3219.0
        System.out.println(n3);//9.0
        System.out.printf("%#010x\n", 13);//0x0000000d
        System.out.printf("0x%#010x\n", 13);//0x0x0000000d
        System.out.printf("0x%#010X\n", 13);//0x0x0000000D
        System.out.printf("%e\n", n1); //1.000000e+10
        System.out.printf("%.2e\n", n1);//1.00e+10
        System.out.printf("%.2f\n", n1);//10000000000.00
        System.out.printf("%1$s , %2$.2f\n", n2, n3);//"X$"表示第X个变量。
        System.out.printf("%9.2f\n",n5);//"9.2"中的9表示输出的长度，2表示小数点后的位数。
        System.out.printf("%+9.2f\n",n5);//"+"表示输出的数带正负号。
        System.out.printf("%-9.4f\n",n5);//"-"表示输出的数左对齐（默认为右对齐）。
        System.out.printf("%+-9.3f\n",n5);//"+-"表示输出的数带正负号且左对齐。
    }
}
