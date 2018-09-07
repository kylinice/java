package DataStructure;
import java.util.Arrays;
public class mergesort {
    private static void mergesort(int a[], int low, int high){
        int mid = (low+high)/2;
        if(low<high){
            mergesort(a, low, mid);
            mergesort(a, mid+1, high);
            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }
    }
    private static void merge(int a[], int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while(left<=mid && right<=high){
            if(a[left]<=a[right]){
                temp[index] = a[left++];
            }else{
                temp[index] = a[right++];
            }
        }


    }
    public static void main(String[] args) {
        int a[] = {49, 35, 12, 56, 67, 95, 19, 49, 8};
        mergesort(a, 0, a.length-1);
        for(int i:a){
            System.out.print(i+",");
        }
    }
}
