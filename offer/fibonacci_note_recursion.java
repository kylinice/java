package offer;

public class fibonacci_note_recursion {
    public static long fib(int n){
        if(n<=0){
            return n;
        }
        long note[] = new long[n+1];
        for(int i=0; i<=n; i++){
            note[i] = -1;
        }
        return fibonacci(n, note);
    }
    public static long fibonacci(int n, long note[]){
        if(note[n] != -1){
            return note[n];
        }
        if(n<=2){
            note[n] = 1;
            return 1;
        }else{
            note[n] = fibonacci(n-1, note) + fibonacci(n-2, note);
        }
        return note[n];
    }

    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();
        long num = fib(6);
        System.out.println(num);
        long end_time = System.currentTimeMillis();
        System.out.println("耗时：" + (end_time - start_time) + "ms");
    }
}
