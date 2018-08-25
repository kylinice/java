package test;

public class HasStatic {
    private static int x = 100;
    public static void main(String[] args) {
        HasStatic hs1 = new HasStatic();
        hs1.x++;
        HasStatic hs2 = new HasStatic();
        hs2.x++;
        hs1 = new HasStatic();
        hs1.x++;
        HasStatic.x--;
        System.out.println(x);
        int i =0;
        int j =0;
        if((++i)>0 || (++j>0)){
            System.out.println(i + " " + j);
        }
        double d = 0.2154d;
        long l = 123L;
        int a = '2';
        System.out.println(a);
    }
}
