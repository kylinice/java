package offer;

public class offer_35_InversePairs {
    public int InversePairs(int []array){
        if(array==null || array.length==0){
            return 0;
        }
        int copy[] = new int[array.length];
        for(int i=0;i<array.length;i++){
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length-1);
        return count;
    }
    public int InversePairsCore(int []array, int[] copy, int low, int high){
        if(low==high){
            return 0;
        }
        int mid = (low+high)/2;
        int left = InversePairsCore(array, copy, low, mid)%1000000007;
        int right = InversePairsCore(array, copy, mid+1, high)%1000000007;
        //i初始化为前半段最后一个数字的下标
        int i = mid;
        //j初始化为后半段最后一个数字的下标
        int j = high;
        int indexCopy = high;
        int count = 0;
        while(i>=low && j>mid){
            if(array[i]>array[j]){
                copy[indexCopy--] = array[i--];
                count += j-mid;
                if(count>=1000000007){
                    count %= 1000000007;
                }
            }else{
                copy[indexCopy--] = array[j--];
            }
        }
        for(;i>=low;i--){
            copy[indexCopy--] = array[i];
        }
        for(;j>mid;j--){
            copy[indexCopy--] = array[j];
        }
        for(int s=low;s<=high;s++)
        {
            array[s] = copy[s];
        }
        return (left+right+count)%1000000007;
    }

    public static void main(String[] args) {
        offer_35_InversePairs test = new offer_35_InversePairs();
        int a[] = {7,5,6,4};
        System.out.println(test.InversePairs(a));
    }

}
