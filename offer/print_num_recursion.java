package offer;

public class print_num_recursion {
    public static void printOut(long n){
        if(n>=10){
            printOut( n/10);
        }
        System.out.println(n%10);
    }
    public static void main(String[] args) {
        long start_time = System.currentTimeMillis();
        printOut(424564456);
        long end_time = System.currentTimeMillis();
        System.out.println(end_time);
        System.out.println(start_time);
        System.out.println(end_time - start_time);
    }
}
