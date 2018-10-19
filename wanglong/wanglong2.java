package wanglong;

import java.util.Scanner;
public class wanglong2 {
    public static int isLucky(int a, int b) {
        int nums = 0;
        if (a > b) {
            try {
                throw new Exception();
            } catch (Exception e) {

            } finally {
                System.out.println("输入参数不合法");
            }
        } else {
            for(int i=a;i<=b;i++){
                if(isLuckyNum(i)){
                    System.out.print(i + ",");
                    nums=nums+1;
                }
            }
            System.out.println();
        }
        return nums;
    }
    public static boolean isLuckyNum(int m){
        boolean flag = false;
        while (m!=0){
            int s = m%10;
            if(s == 8 || s == 6){
                flag = true;
            }else{
                flag = false;
                break;
            }
            m /= 10;
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(isLucky(a,b));
    }
}
