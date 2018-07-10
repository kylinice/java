package offer;

public class quardratic_maximum_contiguous_subsequence {
    public static int subMax(int a[]){
        int maxSum = 0;
        for(int i=0; i<a.length; i++){
            int thisSum = 0;
            for(int j=i; j<a.length; j++){
                thisSum += a[j];
                if(maxSum<thisSum){
                    maxSum = thisSum;
                }
            }

        }
        return maxSum;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int a[] = {3, -9, 4, 5, -1, 5, 7, -4, 3, 1};
        int maxSum = subMax(a);
        System.out.println(maxSum);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
    }

}
