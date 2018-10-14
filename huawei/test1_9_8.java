package huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class test1_9_8 {
    public static void find(ArrayList<String> arr){
        //按照持续时间排序，长的在前
        arr.sort(((o1, o2) -> {
            String[] str1 = o1.split(",");
            String[] str2 = o2.split(",");
            double a1 = Double.parseDouble(str1[1])-Double.parseDouble(str1[0]);
            double a2 = Double.parseDouble(str2[1])-Double.parseDouble(str2[0]);
            return Double.compare(a2, a1);
        }));
        //持续时间相同的，开始时间短的在前
        arr.sort(((o1, o2) -> {
            String[] str1 = o1.split(",");
            String[] str2 = o2.split(",");
            double s1 = Double.parseDouble(str1[1])-Double.parseDouble(str1[0]);
            double s2 = Double.parseDouble(str2[1])-Double.parseDouble(str2[0]);
            double a1 = Double.parseDouble(str1[0]);
            double a2 = Double.parseDouble(str2[0]);
            if(Double.compare(s1, s2)==0){
                return Double.compare(a1, a2);
            }else{
                return 0;
            }
        }));
        //删除不符合的时间段
        for(int i=1;i<arr.size();i++){
            String[] str_i = arr.get(i).split(",");
            double str_i_start = Double.parseDouble(str_i[0]);
            double str_i_end = Double.parseDouble(str_i[1]);
            for(int k=0;k<i;k++){
                String[] str_k = arr.get(k).split(",");
                double str_k_start = Double.parseDouble(str_k[0]);
                double str_k_end = Double.parseDouble(str_k[1]);
                if(str_i_start>=str_k_start && str_i_start<str_k_end ||
                        str_i_end>str_k_start && str_i_end<=str_k_end){
                    arr.remove(i--);
                    break;
                }
            }

        }
        //按照结束时间从小到大排序
        arr.sort(((o1, o2) -> {
            String[] str1 = o1.split(",");
            String[] str2 = o2.split(",");
            double a1 = Double.parseDouble(str1[1]);
            double a2 = Double.parseDouble(str2[1]);
            return Double.compare(a1, a2);
        }));
        for(String i:arr){
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> arr = new ArrayList<>();
        boolean flag = true;
        while(flag){
            String str = in.next();
            if(str.equals("0,0")){
                flag = false;
            }else {
                arr.add(str);
            }
        }
        find(arr);
    }
/*测试样例
13,20
9,11
8,15
0,0

8,10
10,11
12,14
11.1,11.6
13,14
0,0
 */
}
