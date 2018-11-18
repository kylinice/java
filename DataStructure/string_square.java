package DataStructure;

import java.util.ArrayList;
import java.util.Scanner;

/*
给定一字符串，按顺时针顺序输出为一个正方形
 */
public class string_square{
    public static void print_str(String str){
        if(str==null || str.length()<=0){
            System.out.println();
        }else{
            int len = str.length()/4;
            ArrayList<ArrayList<Character>> arr_all = new ArrayList<>();
            for(int i=0;i<=len;i++){
                ArrayList<Character> arr = new ArrayList<>();
                for(int j=0;j<=len;j++){
                    arr.add(' ');
                }
                arr_all.add(arr);
            }
            int index = 0;
            for(int i=0;i<=len;i++){
                arr_all.get(0).set(i,str.charAt(index++));
            }
            for(int i=1;i<len;i++){
                arr_all.get(i).set(len, str.charAt(index++));
            }
            for(int i=len;i>=0;i--){
                arr_all.get(len).set(i, str.charAt(index++));
            }
            for(int i=len-1;i>0;i--){
                arr_all.get(i).set(0, str.charAt(index++));
            }
            for(ArrayList<Character> a:arr_all){
                for(Character ch: a){
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        print_str(str);
    }
}

