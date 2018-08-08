package offer;
/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
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
