package netease;

import java.util.Scanner;

public class test1 {
    public static void fee(int fee){
        if(fee<=5000){
            System.out.println(0);
            return;
        }else{
            double sum = 0;
            double num1 = 3000*0.03;
            double num2 = 9000*0.1;
            double num3 = 13000*0.2;
            double num4 = 10000*0.25;
            double num5 = 20000*0.3;
            double num6 = 25000*0.35;
            int extra = fee - 5000;
            if(extra<=3000 && extra>0){
                sum = extra*0.03;
            }else if(extra>3000 && extra<=12000){
                sum = (extra-3000)*0.1 + num1;
            }else if(extra>12000 && extra<=25000){
                sum = (extra-12000)*0.2 + num1 + num2;
            }else if(extra>25000 && extra<=35000){
                sum = (extra-25000)*0.25 + num1 + num2 + num3;
            }else if(extra>35000 && extra<=55000){
                sum = (extra-35000)*0.3 + num1 + num2 + num3 + num4;
            }else if(extra>=55000 && extra<=80000){
                sum = (extra-55000)*0.35 + num1 + num2 + num3 + num4 + num5;
            }else{
                sum = (extra-80000)*0.45 + num1 + num2 + num3 + num4 + num5 + num6;
            }
            System.out.println(Math.round(sum));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = in.nextInt();
        }
        for(int i=0;i<n;i++){
            fee(a[i]);
        }
    }
}
