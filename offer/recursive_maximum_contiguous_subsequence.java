package offer;

public class recursive_maximum_contiguous_subsequence {
    private static int maxSumRec(int []a, int left, int right){
        if(left == right){
            if(a[left] > 0){
                return a[left];
            }else{
                return 0;
            }
        }

        int center = (left + right)/2;
        int maxLeftSum = maxSumRec(a, left, center);
        int maxRightSum = maxSumRec(a, center+1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for(int i=center; i>=left; i--){
            leftBorderSum += a[i];
            if(leftBorderSum>maxLeftBorderSum){
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for(int i=center+1; i<=right; i++){
            rightBorderSum += a[i];
            if(rightBorderSum>maxRightBorderSum){
                maxRightBorderSum = rightBorderSum;
            }
        }

        int centerSum = maxLeftBorderSum + maxRightBorderSum;
        int temp = maxLeftSum > maxRightSum ? maxLeftBorderSum:maxRightBorderSum;
        int max3 = centerSum > temp ? centerSum:temp;
        return max3;
    }

    public static int maxSubSum3(int a[]){
        return maxSumRec(a, 0, a.length -1);
    }

    public static void main(String args[]){
        long start = System.currentTimeMillis();
        int a[] = {3, -9, 4, 5, -1, 5, 7, -4, 3, 1};
        int maxSum = maxSubSum3(a);
        System.out.println(maxSum);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - start) + "ms");
    }
}
