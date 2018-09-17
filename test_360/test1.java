package test_360;

import java.util.Scanner;
public class test1 {
    public static void find(int[] a){
        int len = a.length;
        if(len<3){
            System.out.println(-1);
        }else{
            int p = 3;
            int[] temp = new int[len];
            for(int i=0;i<p;i++){
                temp[i] = a[i];
            }
            for(int i=1;i<p;i++){
                if(temp[i-1]>temp[i]){
                    swap(temp, i-1, i);
                }
            }
            //判断前三是否可以构成三角形
            int sum = temp[0] + temp[1];
            if(temp[p-1]<sum){
                System.out.println(3);
                return;
            }
            ++p;
            while(p<=len){
                temp[p-1] = a[p-1];
                if(temp[p-2]>a[p-1]){
                   swap(temp, p-1, p-2);
                }
                sum = 0;
                for(int i=0;i<p-1;i++){
                    sum += temp[i];
                    if(i==p-2 && temp[p-1]<sum){
                        System.out.println(p);
                        return;
                    }
                }
                p++;
            }
            System.out.println(-1);
        }
    }
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        find(a);
    }
}
