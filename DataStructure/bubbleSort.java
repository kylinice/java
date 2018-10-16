package DataStructure;

import java.util.Arrays;

public class bubbleSort {
    //暴力
    public static int[] bubbleSort(int[] ints){
        int len = ints.length;
        for(int i=0;i<len;i++){
            for(int j=1;j<len-i;j++){
                if(ints[j-1]>ints[j]){
                    int temp = ints[j-1];
                    ints[j-1] = ints[j];
                    ints[j] = temp;
                }
            }
        }
        return ints;
    }
    //改进1：设置一个标志flag，如果发生了数据交换则flag=true，否则为false。
    public static int[] bubbleSort_1(int[] ints){
        int len = ints.length;
        boolean flag = true;
        while (flag){
            flag = false;
            for(int i=1;i<len;i++){
                if(ints[i-1]>ints[i]){
                    int temp = ints[i-1];
                    ints[i-1] = ints[i];
                    ints[i] = temp;
                    flag = true;
                }
            }
            len--;
        }
        return ints;
    }
    /*
    上面这种方式只要排序完成就会推出排序，这种方式已经减少了时间的浪费。假如现在有一个长度10000的数组，前1000无序,
    后9000有序并且大于前100数据。用上面这种方法，数据交换次数在1000之内，但是剩下9000的数据虽然没有交换，但是每次循环都会进行比较。剩下9000数据已经有序了，我们不要对它们去进行判断浪费不必要的时间。
    改进方式2：还是设置flag，如果进行的数据交换，那么用flag设置边界，这样后面的数据就不会进行判断比较了。
     */
    public static int[] bubbleSort_2(int[] ints){
        int len = ints.length;
        int flag = len;
        while(flag>0){
            flag = 0;
            for(int i=1;i<len;i++){
                if(ints[i-1]>ints[i]){
                    int temp = ints[i-1];
                    ints[i-1] = ints[i];
                    ints[i] = temp;
                    flag = i;//设置最新边界
                }
            }
            //记录边界
            len = flag;
        }

        return ints;
    }
    public static void main(String[] args) {
        int[] ints = new int[10000];
        //向数组写入10000个数据 前1000倒序 ， 后9000顺序。
        for (int i = 0; i < 10000; i++) {
            if (i<=1000) {
                ints[i] = 1000-i;
            }
            else {
                ints[i] = i;
            }
        }
        //ints[10000] = 1;
        System.out.println("排序前：");
        System.out.println(Arrays.toString(ints));
        System.out.println("排序后：");
//调用3种方式，分别记录运行时间
        long startTime = System.currentTimeMillis();//获取当前时间
        System.out.println(Arrays.toString(bubbleSort_2(ints))); // 方式  bubbleSort(ints) 没有经过优化的冒泡
//bubbleSort(ints);
        long endTime = System.currentTimeMillis();//获取当前时间
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");//两个时间相减 = 程序运行时间
    }
}
