package toutiao;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class test2 {
    public static void find(String str){
        String[] test = str.split(";");
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        int len = test.length;
        for(String s:test){
            String[] whole = s.split(",");
            list1.add(Integer.parseInt(whole[0]));
            list2.add(Integer.parseInt(whole[1]));
        }
        Collections.sort(list1);
        Collections.sort(list2);
        StringBuilder bud = new StringBuilder();
        if(list1.size()==1 && list2.size()==1){
            System.out.println(bud.append(list1.get(0)).append(",").append(list2.get(0)));
            return;
        }
        bud.append(list1.get(0));
        int flag;
        for(int i=1;i<list1.size();){
            if(list2.get(i-1)>=list1.get(i)){
                flag=0;
                while(i<list1.size() && list2.get(i-1)>=list1.get(i)){
                    i++;
                }
                bud.append(",").append(list2.get(i - 1)).append(";");
            }else{
                flag=1;
                if(i<list1.size()){
                    bud.append(list1.get(i));
                    i++;
                }
            }
            if(i==list1.size() && flag==1){
                bud.append(",").append(list2.get(list2.size() - 1)).append(";");
            }
        }
        System.out.println(bud.deleteCharAt(bud.length()-1).toString());

    }
    /*
3
1,10;32,45
78,94;5,16
80,100;200,220;16,32
3
1,2;2,3
4,5;6,9
4,7;8,11
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = in.next();
        }
        StringBuilder bud = new StringBuilder();
        for(int i=0;i<n;i++){
            if(i==n-1){
                bud.append(str[i]);
            }else{
                bud.append(str[i]).append(";");
            }
        }
        //System.out.println(bud.toString());
        find(bud.toString());
    }
}
