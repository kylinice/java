package offer;

public class pow {
    public static long powSum(long x ,int n){
        if(n == 0){
            return 1;
        }
        if(n%2 == 0){
            return powSum(x*x, n/2);
        }else{
            return powSum(x*x, n/2)*x;
        }
    }

    public static void main(String[] args) {
        System.out.println(powSum(2,5));
    }
}
