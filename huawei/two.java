package huawei;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.ArrayList;
public class two {
    public String Find(String str){
        if(str.length()==0){
            return null;
        }
        if(str.length()==1){
            //System.out.print(str);
            return str;
        }
        TreeSet<String> tree = new TreeSet<>();
        String s = "" + str.charAt(0);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==str.charAt(i-1)){
                s = s + str.charAt(i);
            }else{
                tree.add(s);
                s = "";
                s = s + str.charAt(i);
            }
            if(i==str.length()-1){
                tree.add(s);
            }
        }
        ArrayList<String> arr = new ArrayList<>();
        for(String i:tree){
            arr.add(i);
        }
        arr.sort((o1, o2) -> {
            if(o1.length()>o2.length()){
                return -1;
            }else if(o1.length()==o2.length()){
                return 0;
            }else{
                return 1;
            }
        });
        return arr.get(0);
    }
    public static void main(String[] args) {
        two test = new two();
        //String str = "aaabbbbbccccccccczzzzzzzzz";
        Scanner in = new Scanner(System.in);
        String test_str = in.next();
        System.out.println(test.Find(test_str));
    }
}
