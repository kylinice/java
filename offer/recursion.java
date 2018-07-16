package offer;

public class recursion {
    public static void recursion_print(int n){
        int temp = n;
        System.out.println("递进：" + n);
        if(n > 0){
            n = n-1;
            recursion_print(n);
        }
        System.out.println("回归：" + n);
    }

    public static void main(String[] args) {
        recursion_print(4);
    }
}
