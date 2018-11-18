package wanglong;

import java.util.Scanner;

public class wanglong {
    public static boolean isHuiwen(int x){
        int temp = x;
        int len = 1;
        //如果是负数
        if(temp<0){
            return false;
        }
        while(temp/len>=10){
            len *= 10;
        }
        while(temp>0){
            if(temp/len != temp%10){
                return false;
            }
            temp %= len;
            temp /= len;
            len /= 100;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(isHuiwen(x));
    }
}
