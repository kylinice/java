package offer;
/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
import java.util.ArrayList;

public class offer_33_GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }else if(index<7){
            return index;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        //为了不遍历之前左右的丑女，做个标记
        int i2=0,i3=0,i5=0;
        while(list.size()<index){
            int m2 = list.get(i2)*2;
            int m3 = list.get(i3)*3;
            int m5 = list.get(i5)*5;
            int min = Math.min(m2, Math.min(m3,m5));
            list.add(min);
            if(min==m2){
                i2++;
            }
            if(min==m3){
                i3++;
            }
            if(min==m5){
                i5++;
            }
        }
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        offer_33_GetUglyNumber_Solution test = new offer_33_GetUglyNumber_Solution();
        System.out.println(test.GetUglyNumber_Solution(3));
    }
}
