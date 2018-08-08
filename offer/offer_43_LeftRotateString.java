package offer;
/*
汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class offer_43_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str==null){
            return null;
        }
        if(n>=str.length() || n==0){
            return str;
        }
        char c[] = str.toCharArray();
        reverse(c, 0, n-1);
        reverse(c, n, c.length-1);
        reverse(c, 0, c.length-1);
        return String.valueOf(c);
    }
    public void reverse(char c[], int begin, int end){
        while(begin<end){
            char temp = c[begin];
            c[begin] = c[end];
            c[end] = temp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        offer_43_LeftRotateString test = new offer_43_LeftRotateString();
        String str = "abcXYZdef";
        System.out.println(test.LeftRotateString(str, 0));
    }
}
