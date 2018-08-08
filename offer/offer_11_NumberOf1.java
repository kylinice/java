package offer;
/*
输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class offer_11_NumberOf1 {

    //举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。
    // 减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
    // 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
    // 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
    public int NumberOf1(int n) {
        int count = 0;
        while(n!=0){
            ++count;
            n = n & (n-1);
        }
        return count;
    }

    public static void main(String[] args) {
        offer_11_NumberOf1 test = new offer_11_NumberOf1();
        System.out.println(test.NumberOf1(-5));
    }
}
