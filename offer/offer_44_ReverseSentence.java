package offer;

public class offer_44_ReverseSentence {
    public String ReverseSentence(String str) {
        if(str==null){
            return null;
        }
        char c[] = str.toCharArray();
        reverse(c, 0, c.length-1);
        int begin=0,end=0;
        while(end<c.length-1){
            if(c[end]==' '){
                reverse(c, begin, end-1);
                begin = end+1;
                end++;
            }else{
                end++;
            }
            if(end==c.length-1){
                reverse(c, begin, end);
            }
        }
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
        offer_44_ReverseSentence test = new offer_44_ReverseSentence();
        String str = "student. a am I";
        System.out.println(test.ReverseSentence(str));
    }
}
