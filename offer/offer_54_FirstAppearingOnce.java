package offer;

import java.util.HashMap;
import java.util.ArrayList;

/*
请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class offer_54_FirstAppearingOnce {
    //Insert one char from stringstream
    HashMap<Character,Integer> map = new HashMap<>();
    ArrayList<Character> list = new ArrayList<>();
    public void Insert(char ch) {
        if(map.containsKey(ch)){
            int index = map.get(ch);
            map.put(ch, index+1);
        }else{
            map.put(ch, 1);
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        Character c = '#';
        for(int i=0;i<list.size();i++){
            if(map.get(list.get(i))==1){
                c = list.get(i);
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        offer_54_FirstAppearingOnce test = new offer_54_FirstAppearingOnce();
        String str = "google";
        for(int i=0;i<str.length();i++){
            test.Insert(str.charAt(i));
        }
        System.out.println(test.FirstAppearingOnce());
    }
}
