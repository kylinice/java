package toutiao;

import java.util.ArrayList;
import java.util.Scanner;

public class test2_9_20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<String> arr = new ArrayList<>();
        //将输入的字符带上序号，存入ArrayList
        for(int i=0;i<n;i++){
            arr.add(i + "," + in.next());
        }
        //只将序号后的字符串排序
        arr.sort((o1, o2) -> {
            String[] str1 = o1.split(",");
            String[] str2 = o2.split(",");
            return str1[1].compareTo(str2[1]);
        });

        if(n==1){
            String[] str1 = arr.get(0).split(",");
            System.out.println(str1[1].charAt(0));
        }else{
            for(int i=1;i<arr.size();i++){
                String[] str1 = arr.get(i-1).split(",");
                String[] str2 = arr.get(i).split(",");
                //标记是否min max交换
                int flag = 0;
                String min = str1[1];
                String max = str2[1];
                // 如果前一个字符串更长，min,max交换
                if(str1[1].length()>str2[1].length()){
                    flag = 1;
                    min = str2[1];
                    max = str1[1];
                }
                //附到i或i-1后的字符串
                String res1 = "";
                String res2 = "";
                for(int j=0;j<min.length();j++){
                    if(min.charAt(j)==max.charAt(j)){
                        res1 += min.charAt(j);
                        res2 += max.charAt(j);
                    }else{
                        res1 += min.charAt(j);
                        res2 += max.charAt(j);
                        break;
                    }
                    //如果遍历完长度最小的字符串，且min max前面的字符都相等
                    if(j==min.length()-1 && min.charAt(j)==max.charAt(j) ){
                        res2 += max.charAt(j+1);
                    }
                }
                //flag为0时，将res1附到i-1中，res2附到i中
                if(flag==0){
                    arr.set(i-1, arr.get(i-1) + "," + res1);
                    arr.set(i, arr.get(i) + "," + res2);
                }else{
                    //flag为1时，需要将res1附到i中，res2附到i-1中
                    arr.set(i-1, arr.get(i-1) + "," + res2);
                    arr.set(i, arr.get(i) + "," + res1);
                }
            }
        }
        for(String str:arr){
            System.out.println(str);
        }
        //按照序号排序
        arr.sort((o1, o2) ->{
            String[] str1 = o1.split(",");
            String[] str2 = o2.split(",");
            return Integer.compare(Integer.parseInt(str1[0]), Integer.parseInt(str2[0]) );
        });

        //找出arr中res长度最长的字符串即为答案
        for (String anArr : arr) {
            String[] temp = anArr.split(",");
            int max = 2;
            for (int j = 2; j < temp.length - 1; j++) {
                if (temp[j + 1].length() > temp[max].length()) {
                    max = j + 1;
                }
            }
            System.out.println(temp[max]);
        }
//        for(String str:arr){
//            System.out.println(str);
//        }
    }
}
/*
13
b
bbb
bytedance
batedance
toutiaohao
iesaweme
iasdsjflsd
toutiaoapp
gsg
iestiktok
ggg
gs
gsf
 */