package offer;

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
