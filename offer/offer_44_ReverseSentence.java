package offer;
/*
牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
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
