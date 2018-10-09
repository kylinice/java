package offer;

import java.util.ArrayList;
import java.util.LinkedList;
public class offer_64_maxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        if(size>num.length || size<1 || num.length==0){
            return arr;
        }
        LinkedList<Integer> indexQueue = new LinkedList<>();
        //对前size个元素处理
        for(int i=0;i<size;i++){
            //num[i]比队尾大的话，就移除队尾
            while(!indexQueue.isEmpty() && num[i]>=num[indexQueue.getLast()]){
                indexQueue.removeLast();
            }
            indexQueue.addLast(i);
        }
        for(int i=size;i<num.length;i++){
            //队头元素永远保持最大
            arr.add(num[indexQueue.getFirst()]);

            //num[i]比队尾大的话，就移除队尾
            while(!indexQueue.isEmpty() && num[i]>=num[indexQueue.getLast()]){
                indexQueue.removeLast();
            }
            //当队头元素已经不包含在滑动窗口中时
            if(!indexQueue.isEmpty() && i-indexQueue.getFirst()==size){
                indexQueue.removeFirst();
            }
            indexQueue.addLast(i);
        }
        //将最后一个元素加入arr
        arr.add(num[indexQueue.getFirst()]);
        for(Integer i:arr){
            System.out.print(i + ",");
        }
        return arr;
    }
    public static void main(String[] args) {
        offer_64_maxInWindows test = new offer_64_maxInWindows();
        int[] a = {2,3,4,2,6,2,5,1};
        test.maxInWindows(a, 3);
    }
}
