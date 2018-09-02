package DataStructure;

public class quicksort {
    private static int partition(int a[], int low, int high){
        int pivot = a[low];
        while(low<high){
            while (low<high && a[high]>pivot){
                high--;
            }
            a[low] = a[high];
            while (low<high && a[low]<=pivot){
                low++;
            }
            a[high] = a[low];
        }
        a[low] = pivot;
        return low;
    }
    private static void quicksort(int a[], int low, int high){
        int pos;
        if (low<high){
            pos = partition(a, low, high);
            quicksort(a, low, pos-1);
            quicksort(a, pos+1, high);
        }
    }
    public static void main(String[] args) {
        int a[] = {49, 35, 12, 56, 67, 95, 19, 49};
        quicksort(a, 0, a.length-1);
        for(int i:a){
            System.out.print(i+",");
        }
    }
}
