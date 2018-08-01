package offer;

import java.util.Arrays;

public class linear_maximum_contiguous_subsequence {

    public static void subMax4(int a[]){
        int max = 0, thisMax = 0;
        for(int i=0; i<a.length; i++){
            thisMax += a[i];
            if(thisMax>max){
                max = thisMax;
            }else if(thisMax<0){
                thisMax = 0;
            }
        }
        System.out.println("最大子序列的值为" + max);
    }
    public static void main(String[] args){
        // 暂时不考虑元素中有0的情况
        long start = System.currentTimeMillis();
        int a[][] = {{3, -9, 4, 5, -1, 5, 7, -4, 3, 1},
                {3, 1, 4, 5, -1, 5, 7, -4, 3, 1},
                {-1, 1, 4, 5, -1, 5, 7, -4, 3, 1},
                {99, -1},
                {99,-100},
                {-1, 99},
                {99},
                {-1},
                {99,-100,2}
                };
        for(int[] a_array:a){
            System.out.println(Arrays.toString(a_array));
            subMax4(a_array);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
    }

}
