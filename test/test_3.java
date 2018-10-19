package test;

public class test_3 {
    public static void main(String[] args) {
        test_3 t1 = new test_3();
        test_3 t2 = new test_3();
        t1 = go(t1,t2);
        System.out.println(t1==t2);

    }
    public static test_3 go(test_3 t1, test_3 t2){
        test_3 temp = t1;
        t1 = t2;
        t2 = temp;
        return temp;
    }
}
