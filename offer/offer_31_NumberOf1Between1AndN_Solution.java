package offer;
/*
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class offer_31_NumberOf1Between1AndN_Solution {

    public int NumberOf1Between1AndN_Solution(int n) {
        if(n<0){
            return 0;
        }
        String str = Integer.toString(n);
        int result = getNumberOf1(str, 0);
        return result;
    }
    public int getNumberOf1(String str, int index){
        int length = str.length() - index;
        if(length==1 && str.charAt(index)=='0'){
            return 0;
        }
        if(length==1){
            return 1;
        }
        //计算最高位的1
        int first = str.charAt(index) - '0';
        int result = 0;
        if(first>1){
            result += exp(length-1);
        }else if(first==1){
            result += 1 + Integer.parseInt(str.substring(index+1));
        }
        //计算除了最高位的其他位
        result += first*(length-1)*exp(length-2);
        //计算后面的
        result += getNumberOf1(str, index+1);
        return result;
    }
    public int exp(int n){
        int result = 1;
        while (n>=1){
            result *= 10;
            n--;
        }
        return result;
    }
    public static void main(String[] args) {
        offer_31_NumberOf1Between1AndN_Solution test = new offer_31_NumberOf1Between1AndN_Solution();
        int result = test.NumberOf1Between1AndN_Solution(100);
        System.out.println(result);
    }

}
