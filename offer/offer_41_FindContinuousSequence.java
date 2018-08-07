package offer;

import java.util.ArrayList;

public class offer_41_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> all = new ArrayList<>();
        if(sum<3){
            return all;
        }
        int small = 1;
        int big = 2;
        int mid = (1+sum)/2;
        int curSum = big+small;
        while(small<mid){
            if(curSum==sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int i=small;i<=big;i++){
                    list.add(i);
                }
                all.add(list);
                big++;
                curSum += big;
            }else if(curSum<sum){
                big++;
                curSum += big;
            }else{
                curSum -= small;
                small++;
            }
        }
        for(int i=0;i<all.size();i++){
            for(int j=0;j<all.get(i).size();j++){
                System.out.print(all.get(i).get(j) + ",");
            }
            System.out.println();
        }
        return all;
    }

    public static void main(String[] args) {
        offer_41_FindContinuousSequence test = new offer_41_FindContinuousSequence();
        test.FindContinuousSequence(9);
    }
}
