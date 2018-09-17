package tencent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
/*
求比n（n<1e6）大的最小正整数，且满足条件：
[n+1,n+2,...,m]的最小公倍数=[1,2,...,m]的最小公倍数
 */
//暴力解法
public class test1 {

    public static void find(long n){
        long min = n + 1;
        ArrayList<Long> arr1 = new ArrayList<>();// [n,m]
        ArrayList<Long> arr2 = new ArrayList<>();//[1,m]
        for(long i=1;i<=min;i++){
            arr2.add(i);
        }
        for(long i=n+1;i<=min;i++){
            arr1.add(i);
        }
        BigInteger min1 = minNum(arr1);
        BigInteger min2 = minNum(arr2);
        while(min<=1000000){
            if(min1.equals(min2)){
                System.out.println(min);
                break;
            }
            min++;
            min1 = minNum(min1, BigInteger.valueOf(min));
            min2 = minNum(min2, BigInteger.valueOf(min));
        }
    }
    //最大公约数
    public static BigInteger maxNum(BigInteger n, BigInteger m){
        BigInteger zero = new BigInteger("0");
        while(!n.remainder(m).equals(zero)){
            BigInteger temp = n.remainder(m);
            n = m;
            m = temp;
        }
        return m;
    }
    //最小公倍数
    public static BigInteger minNum(BigInteger n, BigInteger m){
        BigInteger NM = n.multiply(m);
        return NM.divide(maxNum(n, m));
    }
    //求多个数的最小公倍数
    public static BigInteger minNum(ArrayList<Long> arr){
        BigInteger value = BigInteger.valueOf(arr.get(0));
        for(int i=1;i<arr.size();i++){
            value = minNum(value, BigInteger.valueOf(arr.get(i)));
        }
        return value;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        find(n);
    }
}
