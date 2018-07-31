package offer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;
public class offer_29_GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(k>input.length || k<=0){
            return arr;
        }
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            arr.add(input[i]);
        }
        return arr;
    }
    public ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
        ArrayList<Integer> arr = new ArrayList<>();
        int len = input.length;
        if(k>len || k<=0){
            return arr;
        }
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i=0;i<len;i++){
            if(i+1<=k){
                tree.add(input[i]);
            }else{
                Integer max = tree.last();
                if(max.intValue()>input[i]){
                    tree.pollLast();
                    tree.add(input[i]);
                }
            }
        }
        for(int i=0;i<k;i++) {
            arr.add(tree.pollFirst());
        }
        return arr;
    }



    public static void main(String[] args) {
        offer_29_GetLeastNumbers_Solution test = new offer_29_GetLeastNumbers_Solution();
        int a[] = {2,3,4,7,1,5,9,4};
        int b[] = {2,3,4,7,1,0,9,-333};
        test.GetLeastNumbers_Solution(a,3);
        test.GetLeastNumbers(b,3);
    }

}
