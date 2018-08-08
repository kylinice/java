package offer;
/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */
import java.util.ArrayList;

public class offer_42_FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length<2){
            return list;
        }
        int low = 0;
        int high = array.length-1;
        int curSum = array[0] + array[high];
        while(low<high){
            if(curSum==sum){
                list.add(array[low]);
                list.add(array[high]);
                break;
            }else if(curSum>sum){
                curSum -= array[high--];
                curSum += array[high];
            }else{
                curSum -= array[low++];
                curSum += array[low];
            }
        }
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + ",");
        }
        return list;
    }

    public static void main(String[] args) {
        offer_42_FindNumbersWithSum test = new offer_42_FindNumbersWithSum();
        int a[] = {2,3,4,5,6,7,8};
        int b[] = {-3,-2,-1,1,2,3};
        test.FindNumbersWithSum(a, 7);
    }
}
