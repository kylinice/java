package toutiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class test1_8_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n+1];
        for(int i=0;i<n;i++){
            str[i] = in.next();
        }
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        String[] temp;
        for(int i=0;i<n;i++){
            //System.out.println(str[i]);
            temp = str[i].split(" ");
            ArrayList<Integer> arr_temp = new ArrayList<>();
            for(String s:temp){
                if(!s.equals("0")){
                    arr_temp.add(Integer.parseInt(s)-1);
                }
            }
            arr.add(arr_temp);
        }
        int count = 0;
        ArrayList<Integer> inte = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i).size()==0){
                count++;
                inte.add(i);
            }else{
                set.add(i);
                for(int j=0;j<arr.get(i).size();j++){
                    set.add(arr.get(i).get(j));
                }
            }
        }
        for(int k=0;k<inte.size();k++){
            if(set.contains(inte.get(k))){
                inte.remove(inte.get(k));
                count--;
            }
        }
        System.out.println(count+1);
    }
}

/*
10
0
0
4 0
9 0
9 0
3 0
0
0
0
9 7 0
 */
