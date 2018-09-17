package tencent;

import java.util.Scanner;

/*
求比n（n<1e6）大的最小正整数，且满足条件：
[n+1,n+2,...,m]的最小公倍数=[1,2,...,m]的最小公倍数
 */
//找规律法
public class test1_ac {
    //判断一个数是否是质数
    public static boolean isPrimeNumber(int n){
        if(n<3){
            // 2、3都是质数
            return n>1;
        }else if(n%2==0){
            //偶数先处理
            return false;
        }else{
            for(int i=3;i<=Math.sqrt(n);i=i+2){
                if(n%i == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ans = new int[n+1];
        int temp = 1;
        for(int i=1;i<=n;i++){
            //如果n是2的幂 或 n是质数 或 n-1是2的幂，则ans=2*n
            if( (i&i-1)==0 || isPrimeNumber(i) || (i-1&(i-2))==0){
                temp = i*2;
            }
            //否则ans = temp,即上个满足条件的值
            ans[i] = temp;
        }
        System.out.println(ans[n]);
    }

}
