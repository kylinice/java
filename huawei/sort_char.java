package huawei;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashMap;
public class sort_char {
    public String sort(String str){
        if(str.length()<=1){
            return null;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        TreeSet<Character> tree = new TreeSet<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int count = map.get(str.charAt(i));
                map.put(str.charAt(i), count+1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }
        for(int i=0;i<str.length();i++){
            if(map.get(str.charAt(i))>1){
                tree.add(str.charAt(i));
            }
        }
        if(tree.size()==0){
            return null;
        }
        for(Character i:tree){
            System.out.print(i);
        }
        return null;
    }
    public static void main(String[] args) {
        sort_char test = new sort_char();
        //String str = "ABCABCdd";
        Scanner in = new Scanner(System.in);
        String test_str = in.next();
        test.sort(test_str);
    }
}
