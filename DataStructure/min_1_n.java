package DataStructure;

import java.util.Scanner;

//求1-n的最小公倍数
public class min_1_n {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //素数表，记录小于等于n的素数
        int[] prime = new int[n+1];
        //标记数组
        int[] flag = new int[n+1];
        //素数从2开始
        for(int i=2;i<=n;i++){
            //素数从2、3开始,flag下标都为0,即都是素数
            if(flag[i]==0){
                //prime[0]标记当前素数的下标,下标从1开始,如果是0(即素数),加进素数数组
                prime[++prime[0]] = i;
                //把大于i的i的倍数都标记为1,即偶数
                for(int j=2*i;j<=n;j+=i){
                    flag[j] = 1;
                }
            }
        }
        int answer = 1;
        for(int i=1;i<=prime[0];i++){
            int temp = 1;
            //求prime[i]小于等于n的最小次幂
            while (temp*prime[i] <= n){
                temp *= prime[i];
            }
            answer *= temp;
        }
        //会溢出
        System.out.println(answer);
    }

}
