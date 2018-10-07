package toutiao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test1_9_9 {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    public static void find(String s){
        //记录最长不重复字符串的下标
        int begin=0, end=0;
        //ans记录最长的长度
        int n = s.length(), ans = 0;
        //字符映射数组
        int[] index = new int[128];
        //初始化滑动窗口，i表示滑动窗口最左边的下标，j表示最右边的下标
        for (int j = 0, i = 0; j < n; j++) {
            //更新i的值，i取index[s.charAt(j)]和i中的最大值
            //分两种情况：
            //1.当碰到新的字符时，index[s.charAt(j)]始终为0，i的值不变
            //2.碰到重复字符时，i取index[s.charAt(j)]，即上次出现该字符位置的右一个位置
            i = Math.max(index[s.charAt(j)], i);
            //如果长度更新成功，记录begin和end的值
            if(ans<j-i+1){
                begin = i;
                end = j;
            }
            //更新长度
            ans = Math.max(ans, j - i + 1);
            //为了让下次碰到重复字符时，滑动窗口最左边变为上次出现该字符位置的右一个位置
            index[s.charAt(j)] = j + 1;
        }
        System.out.println(ans);
        //打印字符串
        for(int i=begin;i<=end;i++){
            System.out.print(s.charAt(i));
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        find(str);
    }
}
