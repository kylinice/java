package offer;
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得
所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
import java.util.ArrayList;
public class offer_13_reOrderArray {
    public void reOrderArray(int [] array) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        int i=0;
        for(;i<array.length;i++){
            if(array[i]%2!=0){
                a1.add(array[i]);
            }else{
                a2.add(array[i]);
            }
        }
        for(i=0;i<a1.size();i++){
            array[i] = a1.get(i);
        }
        for(int j=0;j<a2.size();j++){
            array[i] = a2.get(j);
            i++;
        }
        for(i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
    }

    public static void main(String[] args) {
        offer_13_reOrderArray test = new offer_13_reOrderArray();
        int a[] = {4,5,2,3,7,6,8,9};
        test.reOrderArray(a);
    }
}
