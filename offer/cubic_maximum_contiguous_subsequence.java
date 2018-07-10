package offer;

public class cubic_maximum_contiguous_subsequence {
    public static int maxSub(int []a){
        int maxSum = 0;
        for(int i=0; i<a.length; i++){
            for(int j=i; j<a.length; j++){
                int thisSum = 0;
                for(int k=i; k<=j; k++){
                    thisSum += a[k];
                }
                if(thisSum>maxSum){
                    maxSum = thisSum;
                }
            }
        }
        return maxSum;
    }
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int a[] = {3, -9, 4, 5, -1, 5, 7, -4, 3, 1};
        int maxSum = maxSub(a);
        System.out.println(maxSum);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
    }
}
