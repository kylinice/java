package offer;

public class offer_37_GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int num = 0;
        if(array.length>0){
            int first = GetFirstK(array, k, 0, array.length-1);
            int last = GetLastK(array, k, 0, array.length-1);
            if(first>=0 && last>=0){
                num = last - first + 1;
            }
        }
        return num;
    }
    public int GetFirstK(int []array, int k, int start, int end){
        if(start>end){
            return -1;
        }
        int midIndex = (start+end)/2;
        int midArray = array[midIndex];
        if(midArray == k){
            if((midIndex>0 && array[midIndex-1]!=k) || midIndex==0){
                return midIndex;
            }else{
                end = midIndex-1;
            }
        }else if(midArray>k){
            end = midIndex-1;
        }else{
            start = midIndex+1;
        }
        return GetFirstK(array, k, start, end);
    }
    public int GetLastK(int []array, int k, int start, int end){
        if(start>end){
            return -1;
        }
        int midIndex = (start+end)/2;
        int midArray = array[midIndex];
        if(midArray == k){
            if((midIndex<array.length-1 && array[midIndex+1]!=k) || midIndex==array.length-1){
                return midIndex;
            }else{
                start = midIndex+1;
            }
        }else if(midArray>k){
            end = midIndex-1;
        }else{
            start = midIndex+1;
        }
        return GetLastK(array, k, start, end);
    }

    public static void main(String[] args) {
        offer_37_GetNumberOfK test = new offer_37_GetNumberOfK();
        int a[] = {1,2,2,3,3,3,4,4,4,4,7,7,7,7,8,8,8};
        System.out.println(test.GetNumberOfK(a, 8));
    }
}
