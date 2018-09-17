package tencent;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n>0){
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            boolean flag = false;
            for(int i=1;i<=B;i++){
                if(A*i%B == C){
                    flag = true;
                    break;
                }
            }
            System.out.println(flag?"Yes":"No");
            n--;
        }
    }
}
/*
3
91 16 5
58 16 0
96 12 4

 */