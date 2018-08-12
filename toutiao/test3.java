package toutiao;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []x = new int[n];
        int []y = new int[n];
        for(int i=0;i<n;i++){
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }
        System.out.println("no");
    }
}
