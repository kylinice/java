package offer;

public class offer_7_Fibonacci {
    public static int Fibonacci(int n){
        int s=0,a=0,b=1;
        if(n<=1){
            return n;
        }
        while(n>1){
            s = a + b;
            a = b;
            b = s;
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }
}
