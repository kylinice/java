package jibite;

import java.util.Scanner;

public class test1 {
    private static void findMax(int[] a){
        int max = 0, thisMax = 0;
        for(int i=0; i<a.length; i++){
            thisMax += a[i];
            if(thisMax>max){
                max = thisMax;
            }else if(thisMax<0){
                thisMax = 0;
            }
        }
        System.out.println(-max);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = 0 - in.nextInt();
        }
        findMax(a);
    }

}
/*
8
-2 6 -1 -5 4 -7 -2 3
 */