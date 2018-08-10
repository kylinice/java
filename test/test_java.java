package test;

import java.util.*;

class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        for (int i=0; i<num; i++) {
            long n = in.nextLong();
            double res = 0;
            n -= 5000;

            if (n<=0) {
                System.out.println(Math.round(res));
                continue;
            }

            if (n<=3000) {
                res = n*0.03;
                System.out.println(Math.round(res));
                continue;
            }
            res += 90;
            n -= 3000;

            if (n<=9000) {
                res += n*0.1;
                System.out.println(Math.round(res));
                continue;
            }
            res += 900;
            n -= 9000;

            if (n<=13000) {
                res += n*0.2;
                System.out.println(Math.round(res));
                continue;
            }
            res += 2600;
            n -= 13000;

            if (n<=10000) {
                res += n*0.25;
                System.out.println(Math.round(res));
                continue;
            }
            res += 2500;
            n -= 10000;

            if (n<=20000) {
                res += n*0.3;
                System.out.println(Math.round(res));
                continue;
            }
            res += 6000;
            n -= 20000;

            if (n<=25000) {
                res += n*0.35;
                System.out.println(Math.round(res));
                continue;
            }
            res += 8750;
            n -= 25000;

            if (n>0) {
                res += n*0.45;
                System.out.println(Math.round(res));
                continue;
            }
        }
    }
}
