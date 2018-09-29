package offer;

import java.util.Scanner;

/*

有一个国家发现了5座金矿，每座金矿的黄金储量不同，需要参与挖掘的工人数也不同。参与挖矿工人的总数是10人。
每座金矿要么全挖，要么不挖，不能派出一半人挖取一半金矿。要求用程序求解出，要想得到尽可能多的黄金，应该选择挖取哪几座金矿？
每座金矿的分布如下：
200金/3人，300金/4人，350金/3人，400金/5人，500金/5人
 */
/*
转态转移方程
设n为金矿数, m为矿工数, person[n+1]表示从1-n个金矿所需要的人数, gold[n+1]表示从1-n的金矿的数量
F(n,m)表示能挖到的金矿数

F(n,m) = 0 ; (n==1 && m<person[1])
F(n,m) = gold[1] ; (n==1 && m>=person[1])
F(n,m) = F(n-1,m) ; (n>1 && m<person[n]) 矿工数达不到指定数量
F(n,m) = max( F(n-1,m) , F(n-1, m-person[n])+gold[n] )  | (n>1 && m>=person[n])



 */
public class dig_gold {
    public static void maxGold_dynamic(int n, int m, int[] gold, int[] person){
        int[] preResult = new int[m+1];
        int[] result = new int[m+1];
        //填充第一行
        for(int i=1;i<=m;i++){
            //如果人数不够
            if(i<person[1]){
                preResult[i] = 0;
            }else{
                preResult[i] = gold[1];
            }
        }
        //填充其余格子
        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(j<person[i]){
                    result[j] = preResult[j];
                }else{
                    result[j] = Math.max(preResult[j], preResult[j-person[i]] + gold[i]);
                }
            }
            preResult = result.clone();
            //System.arraycopy(result, 0, preResult, 0, preResult.length);
        }
        System.out.println(result[m]);
    }
    public static int maxGold_resursion(int n, int m, int[] gold, int[] person){
        return 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //金矿数
        int n = in.nextInt();
        //矿工数
        int m = in.nextInt();
        int[] gold = new int[n+1];
        int[] person = new int[n+1];
        for(int i=1;i<=n;i++){
            gold[i] = in.nextInt();
        }
        for(int i=1;i<=n;i++){
            person[i] = in.nextInt();
        }
        maxGold_dynamic(n,m,gold,person);
        //int W=13;							//13个人:1250
        //int W=1;							//1个人:0
        //int W=3;							//3个人:350
        //int W=7;							//7个人:650
    }
}
/*
5 10
200 300 350 400 500
3 4 3 5 5
5 13
400 500 200 300 350
5 5 3 4 3
5 3
400 500 200 300 350
5 5 3 4 3
5 7
400 500 200 300 350
5 5 3 4 3
 */