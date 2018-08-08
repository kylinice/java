package offer;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class offer_8_JumpFloor {
    public static int JumpFloor(int n) {
        int s=0,a=1,b=2;
        if(n<=2){
            return n;
        }
        while(n>2){
            s = a + b;
            a = b;
            b = s;
            n--;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor(6));
    }
}
