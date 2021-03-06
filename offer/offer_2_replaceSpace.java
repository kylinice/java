package offer;
/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class offer_2_replaceSpace {
    public String replaceSpace(StringBuffer str){
        if(str.length()==0){
            return null;
        }
        int spacenum = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' '){
                spacenum++;
            }
        }
        int newlength = str.length() + spacenum*2;
        int indexold = str.length()-1;
        int indexnew = newlength-1;
        str.setLength(newlength);
        while(indexold>=0 && indexold<newlength){
            if(str.charAt(indexold)==' '){
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--,'2');
                str.setCharAt(indexnew--,'%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
            --indexold;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        offer_2_replaceSpace test = new offer_2_replaceSpace();
        StringBuffer str = new StringBuffer("We are Happy");
        System.out.println(test.replaceSpace(str));
    }
}
