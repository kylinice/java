package offer;

public class offer_30_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = -1, thisMax = 0;
        for(int i=0; i<array.length; i++){
            thisMax += array[i];
            if(thisMax>max){
                max = thisMax;
            }else if(thisMax<0) {
                thisMax = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        offer_30_FindGreatestSumOfSubArray test = new offer_30_FindGreatestSumOfSubArray();
        int a[] = {3, -9, 4, 5, -1, 5, 7, -4, 3, 1};
        System.out.println(test.FindGreatestSumOfSubArray(a));
    }
}
