package offer;
/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class offer_47_Sum_Solution {
    public int Sum_Solution(int n) {
        int result = n;
        boolean t = result!=0 && (result += Sum_Solution(n-1))!=0;
        return result;
    }

    public static void main(String[] args) {
        offer_47_Sum_Solution test = new offer_47_Sum_Solution();
        System.out.println(test.Sum_Solution(100));
    }
}
