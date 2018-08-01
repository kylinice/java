package offer;

import java.util.HashMap;

public class offer_34_FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int len = str.length();
        if(len<=0){
            return -1;
        }
        if(len==1){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            if(map.containsKey(str.charAt(i))){
                int value = map.get(str.charAt(i));
                map.put(str.charAt(i), value+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        int index = -1;
        for(int i=0;i<len;i++){
            if(map.get(str.charAt(i))==1){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        offer_34_FirstNotRepeatingChar test = new offer_34_FirstNotRepeatingChar();
        System.out.println(test.FirstNotRepeatingChar("sdfkhaksdf"));
    }
}
