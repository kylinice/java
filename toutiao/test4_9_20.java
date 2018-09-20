package toutiao;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
//答案错！
public class test4_9_20 {
    public static BigInteger getNFactorial(int n) {
        int num[] = new int[1000];
        int i, j;
        BigInteger bigInteger;
        if (n == 1 || n == 0) {
            bigInteger = new BigInteger("1");
        } else {
            // p 存放当前结果的位数，h为进位
            int p, h;
            p = 1;
            h = 0;
            num[1] = 1;
            for (i = 2; i <= n; i++) {
                // 使得a[]的每位与i相乘
                for (j = 1; j <= p; j++) {
                    num[j] = num[j] * i + h;
                    h = num[j] / 10;
                    num[j] = num[j] % 10;
                }
                // 表示向新的位置进位
                while (h > 0) {
                    num[j] = h % 10;
                    h = h / 10;
                    j++;
                }
                p = j - 1;
            }
            StringBuilder str = new StringBuilder();
            for (i = p; i >= 1; i--) {
                str.append(num[i]);
            }
            bigInteger = new BigInteger(str.toString());
        }
        return bigInteger;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a= new int[3];
        a[0] = n;
        a[1] = m;
        a[2] = k;
        Arrays.sort(a);
        int a1 = a[2];
        int a2 = a[1];
        int a3 = a[0];
        //(a1+1)!
        BigInteger big_1 = getNFactorial(a1+1);
        //(a1+1-a2)!
        BigInteger big_2 = getNFactorial(a1+1-a2);
        //(a1+a2+1)!
        BigInteger big_3 = getNFactorial(a1+a2+1);
        //(a1+a2+1-a3)!
        BigInteger big_4 = getNFactorial(a1+a2+1-a3);
        BigInteger result = big_1.divide(big_2).divide(getNFactorial(a2))
                .multiply(big_3.divide(big_4).divide(getNFactorial(a3)));
        System.out.println(result);
    }
}
