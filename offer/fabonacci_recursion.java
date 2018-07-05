package offer;
import java.util.Date;
public class fabonacci_recursion {
    public static long fibonacci(int n){
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long fib = fibonacci(50);
        long endTime = System.currentTimeMillis();
        float execTime = (float)(endTime - startTime)/1000;
        System.out.println(fib);
        System.out.println("执行时间：" + execTime + "秒");
    }
}
